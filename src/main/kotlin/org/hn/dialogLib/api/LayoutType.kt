package org.hn.dialogLib.api

enum class LayoutType {
    MULTI,         // DialogType.multiAction
    NOTICE,        // DialogType.notice / notice(action)
    CONFIRMATION,  // DialogType.confirmation(yes,no)
    SERVER_LINKS,  // DialogType.serverLinks(exitAction?, columns)
    DIALOG_LIST    // DialogType.dialogList(…)
}