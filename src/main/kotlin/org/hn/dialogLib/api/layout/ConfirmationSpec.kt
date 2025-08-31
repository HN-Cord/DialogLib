package org.hn.dialogLib.api.layout

import io.papermc.paper.registry.data.dialog.ActionButton
import io.papermc.paper.registry.data.dialog.type.DialogType

@Suppress("UnstableApiUsage")
data class ConfirmationSpec(
    val yes: ActionButton,
    val no: ActionButton
) : LayoutSpec {
    override fun build(): DialogType = DialogType.confirmation(yes, no)
}