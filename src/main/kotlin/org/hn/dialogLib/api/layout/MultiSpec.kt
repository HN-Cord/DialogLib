package org.hn.dialogLib.api.layout

import io.papermc.paper.registry.data.dialog.ActionButton
import io.papermc.paper.registry.data.dialog.type.DialogType

@Suppress("UnstableApiUsage")
data class MultiSpec(
    val buttons: List<ActionButton>,
    val perRow: Int
): LayoutSpec {
    override fun build(): DialogType {
        require(buttons.isNotEmpty()) { "MultiSpec isNotEmpty" }
        val safe = perRow.coerceIn(1, 3)
        return DialogType.multiAction(buttons, null, safe)
    }
}