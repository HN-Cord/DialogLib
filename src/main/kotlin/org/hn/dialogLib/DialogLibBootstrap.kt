package org.hn.dialogLib

import io.papermc.paper.plugin.bootstrap.BootstrapContext
import io.papermc.paper.plugin.bootstrap.PluginBootstrap
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import io.papermc.paper.registry.event.RegistryEvents
import io.papermc.paper.registry.keys.DialogKeys
import org.hn.dialogLib.test.IdleButton
import org.hn.dialogLib.test.SendMsgButton

@Suppress("UnstableApiUsage")
class DialogLibBootstrap: PluginBootstrap {
    override fun bootstrap(context: BootstrapContext) {
        DialogLib.Registry.MAIN_BUTTON
            .register(IdleButton.id) {IdleButton}
            .register(SendMsgButton.id) {SendMsgButton}


        context.lifecycleManager.registerEventHandler(
            RegistryEvents.DIALOG.compose().newHandler { event ->
                event.registry().register(DialogKeys.create(MainDialog.id)) { builder ->
                    MainDialog.configure(builder)
                }
            }
        )

        context.lifecycleManager.registerEventHandler(
            LifecycleEvents.DATAPACK_DISCOVERY.newHandler { event ->
                val uri = javaClass.getResource("/datapack")!!.toURI()
                event.registrar().discoverPack(uri, "DialogLib")
            }
        )
    }
}