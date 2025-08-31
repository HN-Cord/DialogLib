package org.hn.dialogLib.api

import io.papermc.paper.dialog.Dialog
import io.papermc.paper.registry.data.dialog.ActionButton
import io.papermc.paper.registry.data.dialog.DialogBase
import io.papermc.paper.registry.data.dialog.body.DialogBody
import io.papermc.paper.registry.data.dialog.type.DialogType
import net.kyori.adventure.text.Component
import org.hn.dialogLib.api.layout.LayoutSpec
import org.hn.dialogLib.api.util.TextProcessor

class Dag(textProcessor: TextProcessor) {
    val title: Component = textProcessor.parse("title")
    val columns: Int = 3
    val escClosable: Boolean = true
    val specProvider: () -> LayoutSpec

    fun build(): Dialog {
        val t = title
        val bodies = buildBodies()
        val buttons = buildButtons()
        val base = buildBase(t, bodies)
        val type = buildType(buttons)

        return Dialog.create { factory ->
            factory.empty().base(base).type(type)
        }
    }

    private fun buildBodies(): List<DialogBody> {
        return emptyList()
    }

    private fun buildButtons(): List<ActionButton> {
        return listOf()
    }

    private fun buildBase(title: Component, bodies: List<DialogBody>): DialogBase =
        DialogBase.builder(title)
            .body(bodies)
            .canCloseWithEscape(escClosable)
            .build()

    private fun buildType(
        buttons: List<ActionButton>,
        layout: LayoutType,
        columns: Int
    ): DialogType = when (layout) {
        LayoutType.MULTI -> {
            require(buttons.isNotEmpty()) { "MULTI 需要至少 1 個按鈕" }
            DialogType.multiAction(buttons, null, columns.coerceIn(1, 3))
        }
        LayoutType.NOTICE -> {
            if (buttons.isEmpty()) DialogType.notice()
            else DialogType.notice(buttons.first()) // 單顆按鈕
        }
        LayoutType.CONFIRMATION -> {
            require(buttons.size >= 2) { "CONFIRMATION 需要 2 個按鈕（YES/NO）" }
            DialogType.confirmation(buttons[0], buttons[1])
        }
        LayoutType.SERVER_LINKS -> {
            val exit = buttons.firstOrNull()
            DialogType.serverLinks(exit, 1, 200)
        }
        LayoutType.DIALOG_LIST -> error("DIALOG_LIST 需提供 RegistrySet<Dialog>，請於呼叫處組裝")
    }
}