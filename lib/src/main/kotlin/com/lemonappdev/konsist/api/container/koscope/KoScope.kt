package com.lemonappdev.konsist.api.container.koscope

import com.lemonappdev.konsist.api.container.KoFile
import com.lemonappdev.konsist.api.declaration.KoAnnotationDeclaration
import com.lemonappdev.konsist.api.declaration.KoBaseDeclaration
import com.lemonappdev.konsist.api.declaration.KoClassDeclaration
import com.lemonappdev.konsist.api.declaration.KoFunctionDeclaration
import com.lemonappdev.konsist.api.declaration.KoImportDeclaration
import com.lemonappdev.konsist.api.declaration.KoInterfaceDeclaration
import com.lemonappdev.konsist.api.declaration.KoObjectDeclaration
import com.lemonappdev.konsist.api.declaration.KoPackageDeclaration
import com.lemonappdev.konsist.api.declaration.KoPropertyDeclaration
import com.lemonappdev.konsist.api.declaration.KoTypeAliasDeclaration
import com.lemonappdev.konsist.api.provider.KoClassProvider
import com.lemonappdev.konsist.api.provider.KoDeclarationProvider
import com.lemonappdev.konsist.api.provider.KoFunctionProvider
import com.lemonappdev.konsist.api.provider.KoInterfaceProvider
import com.lemonappdev.konsist.api.provider.KoObjectProvider
import com.lemonappdev.konsist.api.provider.KoPropertyProvider

/**
 * Represents a scope of Kotlin declarations.
 */
@Suppress("detekt.TooManyFunctions")
interface KoScope :
    KoDeclarationProvider,
    KoClassProvider,
    KoInterfaceProvider,
    KoObjectProvider,
    KoPropertyProvider,
    KoFunctionProvider {

    /**
     * The files present in the scope.
     *
     * @return a sequence of [KoFile] representing the files in the scope.
     */
    fun files(): Sequence<KoFile>

    /**
     * The imports present in the scope.
     *
     * @return a sequence of [KoImportDeclaration] representing the imports in the scope.
     */
    fun imports(): Sequence<KoImportDeclaration>

    /**
     * The annotations present in the scope.
     *
     * @return a sequence of [KoAnnotationDeclaration] representing the annotations in the scope.
     */
    fun annotations(): Sequence<KoAnnotationDeclaration>

    /**
     * The packages present in the scope.
     *
     * @return a sequence of [KoPackageDeclaration] representing the packages in the scope.
     */
    fun packages(): Sequence<KoPackageDeclaration>

    /**
     * The type aliases present in the scope.
     *
     * @return a sequence of [KoTypeAliasDeclaration] representing the type aliases in the scope.
     */
    fun typeAliases(): Sequence<KoTypeAliasDeclaration>

    /**
     * The scope with given predicate.
     *
     * @param predicate the predicate function to filter file declarations.
     * @return a new [KoScope] containing the file declarations that satisfy the predicate.
     */
    fun slice(predicate: (KoFile) -> Boolean): KoScope

    /**
     * Add a scope files to this scope.
     *
     * @param scope the scope to be added.
     * @return a new [KoScope] containing the combined file declarations from this scope and the specified scope.
     */
    operator fun plus(scope: KoScope): KoScope

    /**
     * Subtract scope files from this scope.
     *
     * @param scope the scope to be subtracted.
     * @return a new [KoScope] containing the file declarations from this scope excluding the file declarations in the specified scope.
     */
    operator fun minus(scope: KoScope): KoScope

    /**
     * Add a scope files and create a new scope.
     *
     * @param scope the scope to be added.
     */
    operator fun plusAssign(scope: KoScope): Unit

    /**
     * Subtract a scope files and create a new scope.
     *
     * @param scope the scope to be subtracted.
     */
    operator fun minusAssign(scope: KoScope): Unit

    /**
     * String representing the scope.
     *
     * @return a string representing the scope.
     */
    override fun toString(): String

    /**
     * Print the scope.
     */
    fun print(): Unit

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param other the object to compare.
     * @return `true` if the objects are equal, `false` otherwise.
     */
    override fun equals(other: Any?): Boolean

    /**
     * Returns a hash code value for the object.
     *
     * @return the hash code value.
     */
    override fun hashCode(): Int
}
