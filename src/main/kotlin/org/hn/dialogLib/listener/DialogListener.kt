package org.hn.dialogLib.listener

import io.papermc.paper.connection.PlayerGameConnection
import io.papermc.paper.event.player.PlayerCustomClickEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.hn.dialogLib.DialogLib

@Suppress("UnstableApiUsage")
class DialogListener: Listener {

    @EventHandler
    fun onCustomClick(event: PlayerCustomClickEvent) {
        val id = event.identifier
        val connection = event.commonConnection
        val player = (connection as? PlayerGameConnection)?.player ?: return

        DialogLib.Registry.BUTTON.get(id)?.onClick(event, player)
    }
}