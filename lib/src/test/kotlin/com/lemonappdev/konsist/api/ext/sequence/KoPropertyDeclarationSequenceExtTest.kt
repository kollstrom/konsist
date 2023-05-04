package com.lemonappdev.konsist.api.ext.sequence

import com.lemonappdev.konsist.core.declaration.KoPropertyDeclarationImpl
import com.lemonappdev.konsist.testdata.SampleType
import com.lemonappdev.konsist.testdata.SampleType1
import com.lemonappdev.konsist.testdata.SampleType2
import io.mockk.every
import io.mockk.mockk
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoPropertyDeclarationSequenceExtTest {
    @Test
    fun `withVarModifier() returns property1 with var modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { isVar } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { isVar } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withVarModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutVarModifier() returns property2 without var modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { isVar } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { isVar } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutVarModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withValModifier() returns property1 with val modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { isVal } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { isVal } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withValModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutValModifier() returns property2 without val modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { isVal } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { isVal } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutValModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withLateinitModifier() returns property1 with lateinit modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasLateinitModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasLateinitModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withLateinitModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutLateinitModifier() returns property2 without lateinit modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasLateinitModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasLateinitModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutLateinitModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withOverrideModifier() returns property1 with override modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasOverrideModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasOverrideModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withOverrideModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutOverrideModifier() returns property2 without override modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasOverrideModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasOverrideModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutOverrideModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withAbstractModifier() returns property1 with abstract modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasAbstractModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasAbstractModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withAbstractModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutAbstractModifier() returns property2 without abstract modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasAbstractModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasAbstractModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutAbstractModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withOpenModifier() returns property1 with open modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasOpenModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasOpenModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withOpenModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutOpenModifier() returns property2 without open modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasOpenModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasOpenModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutOpenModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withFinalModifier() returns property1 with final modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasFinalModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasFinalModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withFinalModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutFinalModifier() returns property2 without final modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasFinalModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasFinalModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutFinalModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withActualModifier() returns property1 with actual modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasActualModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasActualModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withActualModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutActualModifier() returns property2 without actual modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasActualModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasActualModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutActualModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withExpectModifier() returns property1 with expect modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasExpectModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasExpectModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withExpectModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutExpectModifier() returns property2 without expect modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasExpectModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasExpectModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutExpectModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withConstModifier() returns property1 with const modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasConstModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasConstModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withConstModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutConstModifier() returns property2 without const modifier`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasConstModifier() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasConstModifier() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutConstModifier()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withExtension() returns property1 which is extension`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { isExtension() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { isExtension() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withExtension()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutExtension() returns property2 which is not extension`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { isExtension() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { isExtension() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutExtension()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withDelegate() returns property1 which has delegate`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasDelegate() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasDelegate() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withDelegate()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withDelegate(name) returns properties which have one of given delegate names`() {
        // given
        val delegateName1 = "DelegateName1"
        val delegateName2 = "DelegateName2"
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasDelegate(delegateName1) } returns true
            every { hasDelegate(delegateName2) } returns false
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasDelegate(delegateName1) } returns false
            every { hasDelegate(delegateName2) } returns true
        }
        val property3: KoPropertyDeclarationImpl = mockk {
            every { hasDelegate(delegateName1) } returns false
            every { hasDelegate(delegateName2) } returns false
        }
        val properties = sequenceOf(property1, property2, property3)

        // when
        val sut = properties.withDelegate(delegateName1, delegateName2)

        // then
        sut.toList() shouldBeEqualTo listOf(property1, property2)
    }

    @Test
    fun `withoutDelegate() returns property2 which has not delegate`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasDelegate() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasDelegate() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutDelegate()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withoutDelegate(name) returns property3 which has not delegate with given name`() {
        // given
        val delegateName1 = "DelegateName1"
        val delegateName2 = "DelegateName2"
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasDelegate(delegateName1) } returns true
            every { hasDelegate(delegateName2) } returns false
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasDelegate(delegateName1) } returns false
            every { hasDelegate(delegateName2) } returns true
        }
        val property3: KoPropertyDeclarationImpl = mockk {
            every { hasDelegate(delegateName1) } returns false
            every { hasDelegate(delegateName2) } returns false
        }
        val properties = sequenceOf(property1, property2, property3)

        // when
        val sut = properties.withoutDelegate(delegateName1, delegateName2)

        // then
        sut.toList() shouldBeEqualTo listOf(property3)
    }

    @Test
    fun `withType() returns property1 which has type`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasType() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasType() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withType()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withType(name) returns properties which has one of given types`() {
        // given
        val typeName1 = "SampleType1"
        val typeName2 = "SampleType2"
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasType(typeName1) } returns true
            every { hasType(typeName2) } returns false
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasType(typeName1) } returns false
            every { hasType(typeName2) } returns true
        }
        val property3: KoPropertyDeclarationImpl = mockk {
            every { hasType(typeName1) } returns false
            every { hasType(typeName2) } returns false
        }
        val properties = sequenceOf(property1, property2, property3)

        // when
        val sut = properties.withType(typeName1, typeName2)

        // then
        sut.toList() shouldBeEqualTo listOf(property1, property2)
    }

    @Test
    fun `withoutType() returns property2 which has not type`() {
        // given
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasType() } returns true
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasType() } returns false
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutType()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withoutType(name) returns property3 which has not any given type`() {
        // given
        val typeName1 = "SampleType1"
        val typeName2 = "SampleType2"
        val property1: KoPropertyDeclarationImpl = mockk {
            every { hasType(typeName1) } returns true
            every { hasType(typeName2) } returns false
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { hasType(typeName1) } returns false
            every { hasType(typeName2) } returns true
        }
        val property3: KoPropertyDeclarationImpl = mockk {
            every { hasType(typeName1) } returns false
            every { hasType(typeName2) } returns false
        }
        val properties = sequenceOf(property1, property2, property3)

        // when
        val sut = properties.withoutType(typeName1, typeName2)

        // then
        sut.toList() shouldBeEqualTo listOf(property3)
    }

    @Test
    fun `withType() with KClass returns property1 which has given type`() {
        // given
        val typeName1 = "SampleType"
        val typeName2 = "OtherType"
        val property1: KoPropertyDeclarationImpl = mockk {
            every { type?.name } returns typeName1
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { type?.name } returns typeName2
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withTypeOf<SampleType>()

        // then
        sut.toList() shouldBeEqualTo listOf(property1)
    }

    @Test
    fun `withoutType() with KClass returns property2 which has not given type`() {
        // given
        val typeName1 = "SampleType"
        val typeName2 = "OtherType"
        val property1: KoPropertyDeclarationImpl = mockk {
            every { type?.name } returns typeName1
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { type?.name } returns typeName2
        }
        val properties = sequenceOf(property1, property2)

        // when
        val sut = properties.withoutTypeOf<SampleType>()

        // then
        sut.toList() shouldBeEqualTo listOf(property2)
    }

    @Test
    fun `withTypeOf(KClass) returns properties which has one of given return types`() {
        // given
        val typeName1 = "SampleType1"
        val typeName2 = "SampleType2"
        val typeName3 = "SampleType3"
        val property1: KoPropertyDeclarationImpl = mockk {
            every { type?.name } returns typeName1
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { type?.name } returns typeName2
        }
        val property3: KoPropertyDeclarationImpl = mockk {
            every { type?.name } returns typeName3
        }
        val properties = sequenceOf(property1, property2, property3)

        // when
        val sut = properties.withTypeOf(SampleType1::class, SampleType2::class)

        // then
        sut.toList() shouldBeEqualTo listOf(property1, property2)
    }

    @Test
    fun `withoutTypeOf(KClass) returns property which has not any of given return types`() {
        // given
        val typeName1 = "SampleType1"
        val typeName2 = "SampleType2"
        val typeName3 = "SampleType3"
        val property1: KoPropertyDeclarationImpl = mockk {
            every { type?.name } returns typeName1
        }
        val property2: KoPropertyDeclarationImpl = mockk {
            every { type?.name } returns typeName2
        }
        val property3: KoPropertyDeclarationImpl = mockk {
            every { type?.name } returns typeName3
        }
        val properties = sequenceOf(property1, property2, property3)

        // when
        val sut = properties.withoutTypeOf(SampleType1::class, SampleType2::class)

        // then
        sut.toList() shouldBeEqualTo listOf(property3)
    }
}