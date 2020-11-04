/* Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0
license that can be found in the LICENSE file. */
@file:Suppress("ParameterListWrapping")

package com.github.bentito.conbu.framework

import com.github.bentito.conbu.icons.SdkIcons
import com.intellij.framework.FrameworkType
import com.intellij.framework.FrameworkTypeEx
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ModifiableModelsProvider
import com.intellij.openapi.roots.ModifiableRootModel
import javax.swing.Icon
import javax.swing.JCheckBox
import javax.swing.JComponent

class DemoFramework : FrameworkTypeEx(FRAMEWORK_ID) {
    override fun createProvider(): FrameworkSupportInModuleProvider {
        return object : FrameworkSupportInModuleProvider() {
            val frameworkType: FrameworkType
                get() = this@DemoFramework

            override fun getFrameworkType(): FrameworkTypeEx {
                TODO("Not yet implemented")
            }

            override fun createConfigurable(model: FrameworkSupportModel): FrameworkSupportInModuleConfigurable {
                return object : FrameworkSupportInModuleConfigurable() {
                    override fun createComponent(): JComponent {
                        return JCheckBox("SDK Extra Option")
                    }

                    override fun addSupport(
                        module: Module,
                        model: ModifiableRootModel,
                        provider: ModifiableModelsProvider
                    ) {
                        // This is the place to set up a library, generate a specific file, etc
                        // and actually add framework support to a module.
                    }
                }
            }

            override fun isEnabledForModuleType(type: ModuleType<*>): Boolean {
                return true
            }
        }
    }

    companion object {
        const val FRAMEWORK_ID = "org.intellij.sdk.framework.DemoFramework"
    }

    override fun getPresentableName(): String {
        return "SDK Demo Framework"
    }

    override fun getIcon(): Icon {
        return SdkIcons.get()
    }
}
