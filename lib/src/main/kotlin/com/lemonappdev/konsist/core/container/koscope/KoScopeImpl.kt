package com.lemonappdev.konsist.core.container.koscope

import com.lemonappdev.konsist.api.container.KoFile
import com.lemonappdev.konsist.api.container.koscope.KoScope
import com.lemonappdev.konsist.api.declaration.KoClassDeclaration
import com.lemonappdev.konsist.api.declaration.KoFunctionDeclaration
import com.lemonappdev.konsist.api.declaration.KoInterfaceDeclaration
import com.lemonappdev.konsist.api.declaration.KoObjectDeclaration
import com.lemonappdev.konsist.api.declaration.KoPropertyDeclaration
import com.lemonappdev.konsist.api.provider.KoBaseProvider
import com.lemonappdev.konsist.api.provider.KoParentDeclarationProvider
import com.lemonappdev.konsist.core.provider.KoAnnotationProviderCore
import com.lemonappdev.konsist.core.provider.KoClassProviderCore
import com.lemonappdev.konsist.core.provider.KoDeclarationProviderCore
import com.lemonappdev.konsist.core.provider.KoFileProviderCore
import com.lemonappdev.konsist.core.provider.KoFunctionProviderCore
import com.lemonappdev.konsist.core.provider.KoImportProviderCore
import com.lemonappdev.konsist.core.provider.KoInterfaceProviderCore
import com.lemonappdev.konsist.core.provider.KoObjectProviderCore
import com.lemonappdev.konsist.core.provider.KoPackagesProviderCore
import com.lemonappdev.konsist.core.provider.KoPropertyProviderCore
import com.lemonappdev.konsist.core.provider.KoTypeAliasProviderCore
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtFile

@Suppress("detekt.TooManyFunctions")
class KoScopeImpl(
    override var koFiles: Sequence<KoFile>,
) : KoScope,
    KoDeclarationProviderCore,
    KoClassProviderCore,
    KoInterfaceProviderCore,
    KoObjectProviderCore,
    KoPropertyProviderCore,
    KoFunctionProviderCore,
    KoImportProviderCore,
    KoAnnotationProviderCore,
    KoPackagesProviderCore,
    KoTypeAliasProviderCore,
    KoFileProviderCore {
    constructor(koFile: KoFile) : this(sequenceOf(koFile))

    override val ktFile: KtFile? by lazy { null }

    override val parentDeclaration: KoParentDeclarationProvider? by lazy { null }

    override val ktAnnotated: KtAnnotated? by lazy { null }

    override fun classes(
        includeNested: Boolean,
        includeLocal: Boolean,
    ): Sequence<KoClassDeclaration> =
        koFiles.flatMap { it.classes(includeNested, includeLocal) }

    override fun interfaces(
        includeNested: Boolean,
    ): Sequence<KoInterfaceDeclaration> =
        koFiles.flatMap { it.interfaces(includeNested) }

    override fun objects(
        includeNested: Boolean,
    ): Sequence<KoObjectDeclaration> =
        koFiles.flatMap { it.objects(includeNested) }

    override fun functions(
        includeNested: Boolean,
        includeLocal: Boolean,
    ): Sequence<KoFunctionDeclaration> =
        koFiles.flatMap { it.functions(includeNested, includeLocal) }

    override fun declarations(
        includeNested: Boolean,
        includeLocal: Boolean,
    ): Sequence<KoBaseProvider> =
        koFiles.flatMap { it.declarations(includeNested, includeLocal) }

    override fun properties(
        includeNested: Boolean,
        includeLocal: Boolean,
    ): Sequence<KoPropertyDeclaration> =
        koFiles.flatMap { it.properties(includeNested, includeLocal) }

    override fun slice(predicate: (KoFile) -> Boolean): KoScope = KoScopeImpl(koFiles.filter { predicate(it) })

    override operator fun plus(scope: KoScope): KoScope = KoScopeImpl(files + scope.files)

    override operator fun minus(scope: KoScope): KoScope = KoScopeImpl(files - scope.files.toSet())

    override operator fun plusAssign(scope: KoScope) {
        koFiles += scope.files
    }

    override operator fun minusAssign(scope: KoScope) {
        koFiles -= scope.files
    }

    override fun toString(): String = files
        .toList()
        .joinToString("\n") { it.path }

    override fun print() {
        println(toString())
    }

    override fun equals(other: Any?): Boolean = other is KoScope && files.toList() == other.files.toList()

    override fun hashCode(): Int = 31 * 7 + files.toList().hashCode()
}
