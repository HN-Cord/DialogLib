package org.hn.dialogLib.api.util

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.entity.Player
import org.hn.dialogLib.DialogLib
import java.util.*

class TextProcessor(val locale: Locale, val path: String) {
    private val mm = MiniMessage.miniMessage()
    private val lingonLang = DialogLib.lingon.get(locale, path)

    fun parse(key: String): Component {
        val text = lingonLang.get(key)
        return mm.deserialize(text)
    }

    fun send(player: Player, key: String) {
        player.sendMessage(parse(key))
    }
}