package com.smashedcontrollers.sportsontv;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Facebook {

    @Rule
    public ActivityTestRule<Splash> mActivityTestRule = new ActivityTestRule<>(Splash.class);

    @Test
    public void facebook() {
        ViewInteraction loginButton = onView(
                allOf(withId(R.id.login_button), withText("Log in with Facebook"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        loginButton.perform(click());

        ViewInteraction loginButton2 = onView(
                allOf(withId(R.id.login_button), withText("Log in with Facebook"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        loginButton2.perform(click());

        ViewInteraction imageView = onView(
                allOf(withClassName(is("android.widget.ImageView")), isDisplayed()));
        imageView.perform(click());

    }

}
