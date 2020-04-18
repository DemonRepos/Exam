package com.example.apiexam

import android.app.PendingIntent.getActivity
import android.content.Context
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.ActivityTestRule
import com.robotium.solo.Solo
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.apiexam", appContext.packageName)
    }

    @Test
    fun Test1()
    {
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.clearText())
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.typeText("rub"))
        Espresso.onView(ViewMatchers.withId(R.id.press)).perform(ViewActions.click())
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.result)).check(ViewAssertions.matches(ViewMatchers.withText("Russian Federation")))
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.clearText())
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.typeText("cop"))
        Espresso.onView(ViewMatchers.withId(R.id.press)).perform(ViewActions.click())
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.result)).check(ViewAssertions.matches(ViewMatchers.withText("Colombia")))
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.clearText())
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.typeText("uah"))
        Espresso.onView(ViewMatchers.withId(R.id.press)).perform(ViewActions.click())
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.result)).check(ViewAssertions.matches(ViewMatchers.withText("Ukraine")))
    }

    @Test
    fun Test2()
    {
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.clearText())
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.typeText("rub"))
        Espresso.onView(ViewMatchers.withId(R.id.press)).perform(ViewActions.click())
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.result)).check(ViewAssertions.matches(ViewMatchers.withText("Russian Federation")))
        val solo = Solo(getInstrumentation(), activityRule.activity)
        solo.setWiFiData(false)
        solo.setMobileData(false)
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.clearText())
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.typeText("rub"))
        Espresso.onView(ViewMatchers.withId(R.id.press)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.result)).check(ViewAssertions.matches(ViewMatchers.withText("Russian Federation")))
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.clearText())
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.typeText("sek"))
        Espresso.onView(ViewMatchers.withId(R.id.press)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.result)).check(ViewAssertions.matches(ViewMatchers.withText(R.string.error1)))
        solo.setWiFiData(true)
        solo.setMobileData(true)
        Thread.sleep(10000)
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.clearText())
        Espresso.onView(ViewMatchers.withId(R.id.q)).perform(ViewActions.typeText("sek"))
        Espresso.onView(ViewMatchers.withId(R.id.press)).perform(ViewActions.click())
        Thread.sleep(5000)
        Espresso.onView(ViewMatchers.withId(R.id.result)).check(ViewAssertions.matches(ViewMatchers.withText("Sweden")))
    }
}
