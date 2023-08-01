package com.lemonappdev.konsist.core.provider

import com.lemonappdev.konsist.api.declaration.KoConstructorDeclaration
import com.lemonappdev.konsist.api.provider.KoConstructorProvider

internal interface KoConstructorProviderCore :
    KoConstructorProvider,
    KoPrimaryConstructorProviderCore,
    KoSecondaryConstructorsProviderCore,
    KoBaseProviderCore {
    override val constructors: List<KoConstructorDeclaration>
        get() = listOf(primaryConstructor as KoConstructorDeclaration) + secondaryConstructors
}
