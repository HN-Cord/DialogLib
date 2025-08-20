package org.hn.dialogLib.dialog

import io.papermc.paper.event.player.PlayerCustomClickEvent
import io.papermc.paper.registry.data.dialog.ActionButton
import io.papermc.paper.registry.data.dialog.action.DialogAction
import net.kyori.adventure.key.Key
import net.kyori.adventure.nbt.api.BinaryTagHolder
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.hn.dialogLib.DialogLib

@Suppress("UnstableApiUsage")
abstract class DialogButton(
    val id: Key,
    val title: Component,
    val additions: BinaryTagHolder? = null
) {

    init {
        DialogLib.Registry.BUTTON.register(id) { this }
    }

    internal val button = ActionButton.builder(title)
        .action(DialogAction.customClick(id, additions))
        .build()

    open fun onClick(event: PlayerCustomClickEvent, player: Player) {

    }
}