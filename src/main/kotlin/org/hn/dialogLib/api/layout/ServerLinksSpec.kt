package org.hn.dialogLib.api.layout

import io.papermc.paper.registry.data.dialog.ActionButton
import io.papermc.paper.registry.data.dialog.type.DialogType

data class ServerLinksSpec(
    val exit: ActionButton? = null,
    val columns: Int = 1,
    val buttonWidth: Int = 200
) : LayoutSpec {
    override fun build(): DialogType {
        val cols = columns.coerceAtLeast(1)
        val width = buttonWidth.coerceIn(1, 1024)
        return DialogType.serverLinks(exit, cols, width)
    }
}