package com.github.bentito.conbu.icons

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object SdkIcons {
    private val icon = IconLoader.getIcon("/icons/sdk_16.svg")
    fun get(): Icon {
        return icon
    }
}
