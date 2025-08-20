package org.hn.dialogLib

import org.bukkit.plugin.java.JavaPlugin
import org.hn.dialogLib.dialog.DialogButton
import org.hn.dialogLib.listener.DialogListener

class DialogLib : JavaPlugin() {

    companion object {
        lateinit var instance: DialogLib
    }

    override fun onEnable() {
        instance = this

        server.pluginManager.registerEvents(DialogListener(), this)
    }

    override fun onDisable() {
    }

    object Registry {
        val BUTTON = org.hn.dialogLib.registry.Registry<DialogButton>()
        val MAIN_BUTTON = org.hn.dialogLib.registry.Registry<DialogButton>()
    }
}
