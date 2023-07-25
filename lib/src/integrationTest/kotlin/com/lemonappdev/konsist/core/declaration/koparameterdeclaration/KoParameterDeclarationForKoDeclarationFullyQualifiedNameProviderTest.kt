package com.lemonappdev.konsist.core.declaration.koparameterdeclaration

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoParameterDeclarationForKoDeclarationFullyQualifiedNameProviderTest {
    @Test
    fun `parameter-fully-qualified-name`() {
        // given
        val sut = getSnippetFile("parameter-fully-qualified-name")
            .classes()
            .first()
            .primaryConstructor
            ?.parameters
            ?.first()

        // then
        sut?.fullyQualifiedName shouldBeEqualTo "com.lemonappdev.konsist.testdata.SampleClassWithParameter.sampleParameter"
    }

    @Test
    fun `parameter-fully-qualified-name-without-package`() {
        // given
        val sut = getSnippetFile("parameter-fully-qualified-name-without-package")
            .classes()
            .first()
            .primaryConstructor
            ?.parameters
            ?.first()

        // then
        sut?.fullyQualifiedName shouldBeEqualTo "SampleClassWithParameter.sampleParameter"
    }

    private fun getSnippetFile(fileName: String) =
        getSnippetKoScope("core/declaration/koparameterdeclaration/snippet/forkodeclarationfullyqualifiednameprovider/", fileName)
}
