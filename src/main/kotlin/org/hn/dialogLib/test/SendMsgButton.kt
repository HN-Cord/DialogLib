package org.hn.dialogLib.test

import io.papermc.paper.event.player.PlayerCustomClickEvent
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.hn.dialogLib.dialog.DialogButton

object SendMsgButton: DialogButton(
    Key.key("dialoglib:send_msg"),
    Component.text("Send Message")
) {

    override fun onClick(event: PlayerCustomClickEvent, player: Player) {
        player.sendMessage("點擊了按鈕") // 不關閉、不跳轉 → 視窗保持
    }
}