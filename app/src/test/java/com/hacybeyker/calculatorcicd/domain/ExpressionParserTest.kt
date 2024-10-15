package com.hacybeyker.calculatorcicd.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionParserTest {

    private lateinit var parser: ExpressionParser

    @Test
    fun `Simple expression is properly parsed`() {
        //GIVEN
        val expected = listOf(
            ExpressionPart.Number(number = 3.0),
            ExpressionPart.Op(operation = Operation.ADD),
            ExpressionPart.Number(number = 5.0),
            ExpressionPart.Op(operation = Operation.SUBTRACT),
            ExpressionPart.Number(number = 3.0),
            ExpressionPart.Op(operation = Operation.MULTIPLY),
            ExpressionPart.Number(number = 4.0),
            ExpressionPart.Op(operation = Operation.DIVIDE),
            ExpressionPart.Number(number = 3.0)
        )

        parser = ExpressionParser("3 + 5 - 3 * 4 / 3")

        //WHEN
        val actual = parser.parse()

        //THEN
        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with parentheses is properly parsed`() {
        //GIVEN
        val expected = listOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(operation = Operation.SUBTRACT),
            ExpressionPart.Parentheses(type = ParenthesesType.Opening),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(operation = Operation.MULTIPLY),
            ExpressionPart.Number(5.0),
            ExpressionPart.Parentheses(type = ParenthesesType.Closing)
        )
        parser = ExpressionParser("4-(4*5)")

        //WHEN
        val actual = parser.parse()

        //THEN
        assertThat(expected).isEqualTo(actual)
    }

}