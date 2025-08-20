package org.hn.dialogLib

import io.papermc.paper.registry.data.dialog.ActionButton
import io.papermc.paper.registry.data.dialog.DialogRegistryEntry
import io.papermc.paper.registry.data.dialog.body.DialogBody
import io.papermc.paper.registry.data.dialog.type.DialogType
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import org.hn.dialogLib.dialog.DialogGUI

@Suppress("UnstableApiUsage")
object MainDialog: DialogGUI(Key.key("dialoglib:main")) {
    override val title: Component = Component.text("DialogLib")
    override val description: List<DialogBody> = listOf()

    fun configure(builder: DialogRegistryEntry.Builder) {
        val close = ActionButton.builder(Component.text("關閉"))
            .build()

        builder
            .base(buildBase())
            .type(
                DialogType.multiAction(
                    DialogLib.Registry.MAIN_BUTTON.getValues().toList().map { it.button },
                    close,
                    2
                )
            )
    }
}