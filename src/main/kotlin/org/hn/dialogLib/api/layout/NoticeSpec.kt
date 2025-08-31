package org.hn.dialogLib.api.layout

import io.papermc.paper.registry.data.dialog.ActionButton
import io.papermc.paper.registry.data.dialog.type.DialogType

@Suppress("UnstableApiUsage")
data class NoticeSpec(
    val okButton: ActionButton? = null
) : LayoutSpec {
    override fun build(): DialogType =
        okButton?.let { DialogType.notice(it) } ?: DialogType.notice()
}