package org.hn.dialogLib.dialog

import io.papermc.paper.dialog.Dialog
import io.papermc.paper.registry.data.dialog.DialogBase
import io.papermc.paper.registry.data.dialog.body.DialogBody
import io.papermc.paper.registry.data.dialog.type.DialogType
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component

@Suppress("UnstableApiUsage")
abstract class DialogGUI(
    val id: Key
) {
    abstract val title: Component
    abstract val description: List<DialogBody>
    open val type: DialogType? = null
    open val canCloseWithEscape: Boolean = true

    fun asDialog(): Dialog {
        return Dialog.create { factory ->
            val builder = factory.empty()
            builder.base(buildBase())
            type?.let { builder.type(it) }
        }
    }

    /**
     * 構建基礎對話框
     */
    protected fun buildBase(): DialogBase {
        return DialogBase.builder(title)
            .body(description)
            .canCloseWithEscape(canCloseWithEscape)
            .build()
    }
}