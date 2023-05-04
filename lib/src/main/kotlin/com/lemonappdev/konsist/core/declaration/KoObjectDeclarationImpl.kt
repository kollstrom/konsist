package com.lemonappdev.konsist.core.declaration

import com.lemonappdev.konsist.api.KoModifier
import com.lemonappdev.konsist.api.declaration.KoObjectDeclaration
import com.lemonappdev.konsist.core.cache.KoDeclarationCache
import org.jetbrains.kotlin.psi.KtObjectDeclaration

internal class KoObjectDeclarationImpl(
    ktObjectDeclaration: KtObjectDeclaration,
) :
    KoComplexDeclarationImpl(ktObjectDeclaration),
    KoObjectDeclaration {
    override fun hasDataModifier() = hasModifiers(KoModifier.DATA)

    internal companion object {
        private val cache = KoDeclarationCache<KoObjectDeclarationImpl>()

        internal fun getInstance(ktObjectDeclaration: KtObjectDeclaration) =
            cache.getOrCreateInstance(ktObjectDeclaration) { KoObjectDeclarationImpl(ktObjectDeclaration) }
    }
}