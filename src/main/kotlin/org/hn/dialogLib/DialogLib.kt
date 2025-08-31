package org.hn.dialogLib

import io.aitchn.lingon.Lingon
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.plugin.java.JavaPlugin
import org.hn.dialogLib.dialog.DialogButton
import org.hn.dialogLib.listener.DialogListener
import java.util.Locale

class DialogLib : JavaPlugin() {

    companion object {
        lateinit var instance: DialogLib
            private set

        lateinit var lingon: Lingon
            private set

        lateinit var miniMessage: MiniMessage
            private set
    }

    override fun onEnable() {
        instance = this
        lingon = Lingon.getInstance(this.javaClass, dataFolder.toPath(), Locale.ENGLISH)
        miniMessage = MiniMessage.miniMessage()

        server.pluginManager.registerEvents(DialogListener(), this)
    }

    override fun onDisable() {
    }

    object Registry {
        val BUTTON = org.hn.dialogLib.registry.Registry<DialogButton>()
        val MAIN_BUTTON = org.hn.dialogLib.registry.Registry<DialogButton>()
    }
}
