package com.lemonappdev.konsist.api.provider

import com.lemonappdev.konsist.api.declaration.KoBaseDeclaration

interface KoParentProvider {
    val parentDeclaration: KoParentProvider?
}
