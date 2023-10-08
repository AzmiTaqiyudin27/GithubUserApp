package com.bangkitdicoding.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bangkitdicoding.githubuserapp.test.R
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FavoriteActivityTest{
    @Before
    fun setUp(){
        ActivityScenario.launch(FavoriteActivity::class.java)
    }

    @Test
    fun testFavoriteUserListDisplay(){
        Espresso.onView(ViewMatchers.withId(com.bangkitdicoding.githubuserapp.R.id.rv_favorite))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}


