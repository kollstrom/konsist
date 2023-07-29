package com.lemonappdev.konsist.api.ext.sequence

import com.lemonappdev.konsist.api.provider.KoDelegateProvider

/**
 * Sequence containing all declarations with delegate with given name.
 *
 * @param names The delegate names to include.
 * @return A sequence containing declarations with the specified delegate name(s) (or any delegate if [names] is empty).
 */
fun <T : KoDelegateProvider> Sequence<T>.withDelegate(vararg names: String): Sequence<T> = filter {
    when {
        names.isEmpty() -> it.hasDelegate()
        else -> names.any { name -> it.hasDelegate(name) }
    }
}

/**
 * Sequence containing all declarations without delegate with given name.
 *
 * @param names The delegate names to exclude.
 * @return A sequence containing declarations without the specified delegate name(s) (or none delegate if [names] is empty).
 */
fun <T : KoDelegateProvider> Sequence<T>.withoutDelegate(vararg names: String): Sequence<T> = filter {
    when {
        names.isEmpty() -> !it.hasDelegate()
        else -> names.none { name -> it.hasDelegate(name) }
    }
}