package com.example.apiexam

import android.content.res.Resources
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    val tester = Tester()
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        assertEquals("Russian Federation", tester.test("rub"))
        assertEquals("Columbia", tester.test("cop"))
        assertEquals("Ukraine", tester.test("uah"))
        assertEquals("Sweden", tester.test("sek"))
        assertEquals(Resources.getSystem().getString(R.string.error2), tester.test("rgb"))
    }
}
