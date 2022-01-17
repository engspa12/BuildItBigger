package com.udacity.gradle.builditbigger;


import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.ViewInteraction;
import androidx.test.rule.ActivityTestRule;


import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

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
