package org.hn.dialogLib.api.layout

import io.papermc.paper.registry.data.dialog.type.DialogType

@Suppress("UnstableApiUsage")
sealed interface LayoutSpec {
    fun build(): DialogType
}