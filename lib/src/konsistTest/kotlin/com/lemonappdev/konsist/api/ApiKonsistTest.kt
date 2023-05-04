package com.lemonappdev.konsist.api

import com.lemonappdev.konsist.core.verify.assert
import org.junit.jupiter.api.Test

class ApiKonsistTest {
    @Test
    fun `every api declaration has kdoc`() {
        apiPackageScope
            .declarations(includeNested = true)
            .assert { it.hasKoDoc() }
    }

    companion object {
        val apiPackageScope = Konsist.scopeFromPackage("com.lemonappdev.konsist.api..", sourceSet = "main")
    }
}