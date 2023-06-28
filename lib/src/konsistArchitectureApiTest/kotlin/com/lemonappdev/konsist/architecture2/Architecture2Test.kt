package com.lemonappdev.konsist.architecture2

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.core.architecture.Layer
import com.lemonappdev.konsist.core.exception.KoCheckFailedException
import com.lemonappdev.konsist.core.filesystem.PathProvider
import com.lemonappdev.konsist.core.verify.assert
import org.amshove.kluent.shouldThrow
import org.amshove.kluent.withMessage
import org.junit.jupiter.api.Test

class Architecture2Test {
    private val rootPath = PathProvider.getInstance().rootProjectPath

    @Test
    fun `passes when dependency is set that presentation layer is depend on domain layer`() {
        // given
        val domain = Layer("Domain", "com.lemonappdev.konsist.architecture2.project.domain..")
        val presentation = Layer("Presentation", "com.lemonappdev.konsist.architecture2.project.presentation..")

        val koArchitecture = Konsist
            .architecture(domain, presentation)
            .addDependencies {
                domain.dependOnNothing()
                presentation.dependsOn(domain)
            }
        val scope = Konsist.scopeFromDirectory("lib/src/konsistArchitectureApiTest/kotlin/com/lemonappdev/konsist/architecture2/project")

        // then
        koArchitecture.assert(scope)
    }

    @Test
    fun `fails when dependency is set that domain layer is depend on presentation layer`() {
        // given
        val domain = Layer("Domain", "com.lemonappdev.konsist.architecture2.project.domain..")
        val presentation = Layer("Presentation", "com.lemonappdev.konsist.architecture2.project.presentation..")

        val koArchitecture = Konsist
            .architecture(domain, presentation)
            .addDependencies {
                presentation.dependOnNothing()
                domain.dependsOn(presentation)
            }
        val scope = Konsist.scopeFromDirectory("lib/src/konsistArchitectureApiTest/kotlin/com/lemonappdev/konsist/architecture2/project")

        val sut = { koArchitecture.assert(scope) }

        // then
        sut shouldThrow KoCheckFailedException::class withMessage """
            Assert 'fails when dependency is set that domain layer is depend on presentation layer' has failed. Invalid dependencies at (1):
            Layer: Presentation defined by: com.lemonappdev.konsist.architecture2.project.presentation.. . Invalid files:
            $rootPath/lib/src/konsistArchitectureApiTest/kotlin/com/lemonappdev/konsist/architecture2/project/presentation/sample/PresentationThirdClass.kt
        """.trimIndent()
    }
}
