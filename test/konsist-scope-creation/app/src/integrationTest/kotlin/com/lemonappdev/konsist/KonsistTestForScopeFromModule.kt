package com.lemonappdev.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.ext.mapToFilePaths
import com.lemonappdev.konsist.util.PathProvider.appIntegrationTestSourceSetDirectory
import com.lemonappdev.konsist.util.PathProvider.appMainSourceSetDirectory
import com.lemonappdev.konsist.util.PathProvider.dataMainSourceSetDirectory
import com.lemonappdev.konsist.util.PathProvider.dataTestSourceSetDirectory
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KonsistTestForScopeFromModule {
    @Test
    fun `scopeFromModule for app module`() {
        // given
        val sut = Konsist
            .scopeFromModule("app")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForRootProjectPath.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromDirectory.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromFile.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromModule.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromPackage.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromProduction.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromProject.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromProjectDirectory.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromProjectFile.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromSourceSet.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForToString.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/ext/KoScopeExt.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/util/PathProvider.kt",
                "$appIntegrationTestSourceSetDirectory/sample/AppClassTest.kt",
                "$appIntegrationTestSourceSetDirectory/sample/data/AppDataClassTest.kt",
                "$appMainSourceSetDirectory/sample/AppClass.kt",
                "$appMainSourceSetDirectory/sample/data/AppDataClass.kt",
            ),
        )
    }

    @Test
    fun `scopeFromModule for data module`() {
        // given
        val sut = Konsist
            .scopeFromModule("data")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$dataMainSourceSetDirectory/sample/LibClass.kt",
                "$dataMainSourceSetDirectory/sample/data/LibDataClass.kt",
                "$dataTestSourceSetDirectory/sample/LibClassTest.kt",
                "$dataTestSourceSetDirectory/sample/data/LibDataClassTest.kt",
            ),
        )
    }

    @Test
    fun `scopeFromModule for app and data modules`() {
        // given
        val sut = Konsist
            .scopeFromModule("app", "data")
            .mapToFilePaths()

        // then
        sut.shouldBeEqualTo(
            listOf(
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForRootProjectPath.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromDirectory.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromFile.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromModule.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromPackage.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromProduction.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromProject.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromProjectDirectory.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromProjectFile.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromSourceSet.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForScopeFromTest.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/KonsistTestForToString.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/ext/KoScopeExt.kt",
                "$appIntegrationTestSourceSetDirectory/konsist/util/PathProvider.kt",
                "$appIntegrationTestSourceSetDirectory/sample/AppClassTest.kt",
                "$appIntegrationTestSourceSetDirectory/sample/data/AppDataClassTest.kt",
                "$appMainSourceSetDirectory/sample/AppClass.kt",
                "$appMainSourceSetDirectory/sample/data/AppDataClass.kt",
                "$dataMainSourceSetDirectory/sample/LibClass.kt",
                "$dataMainSourceSetDirectory/sample/data/LibDataClass.kt",
                "$dataTestSourceSetDirectory/sample/LibClassTest.kt",
                "$dataTestSourceSetDirectory/sample/data/LibDataClassTest.kt",
            ),
        )
    }
}