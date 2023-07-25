package com.lemonappdev.konsist.core.declaration.kotypealiasdeclaration

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoTypeAliasDeclarationForKoDeclarationFullyQualifiedNameProviderTest {
    @Test
    fun `typealias-fully-qualified-name`() {
        // given
        val sut = getSnippetFile("typealias-fully-qualified-name")
            .typeAliases
            .first()

        // then
        sut.fullyQualifiedName shouldBeEqualTo "com.lemonappdev.konsist.testdata.SampleTypeAlias"
    }

    @Test
    fun `typealias-fully-qualified-name-without-package`() {
        // given
        val sut = getSnippetFile("typealias-fully-qualified-name-without-package")
            .typeAliases
            .first()

        // then
        sut.fullyQualifiedName shouldBeEqualTo "SampleTypeAlias"
    }

    private fun getSnippetFile(fileName: String) =
        getSnippetKoScope("core/declaration/kotypealiasdeclaration/snippet/forkodeclarationfullyqualifiednameprovider/", fileName)
}
