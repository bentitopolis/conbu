package com.github.bentito.conbu.services

import com.intellij.openapi.project.Project
import com.github.bentito.conbu.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
