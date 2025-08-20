package org.hn.dialogLib.test

import io.papermc.paper.event.player.PlayerCustomClickEvent
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.hn.dialogLib.dialog.DialogButton

object IdleButton: DialogButton(
    Key.key("dialoglib:idle"),
    Component.text("Idle")
) {

    override fun onClick(event: PlayerCustomClickEvent, player: Player) {
    }
}