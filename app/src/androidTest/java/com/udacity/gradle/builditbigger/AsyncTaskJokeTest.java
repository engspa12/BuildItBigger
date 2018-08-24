package com.udacity.gradle.builditbigger;


import android.os.Handler;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AllOf.allOf;


public class AsyncTaskJokeTest {

    private static final String LOG = AsyncTaskJokeTest.class.getSimpleName();


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);



    @Test
    public void gettingJokeFromAsyncTaskTest() {
        onView(withId(R.id.tell_joke_button)).perform(click());
        onView(withId(R.id.joke_text_view)).check(matches(withText(mActivityTestRule.getActivity().getResources().getString(R.string.joke_text_test))));
    }

}
