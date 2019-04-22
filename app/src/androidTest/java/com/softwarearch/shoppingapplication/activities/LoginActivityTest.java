package com.softwarearch.shoppingapplication.activities;

import android.view.View;

import com.google.android.material.textfield.TextInputLayout;
import com.softwarearch.shoppingapplication.R;
import com.softwarearch.shoppingapplication.view.activities.LoginActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.annotation.StringRes;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    public static Matcher<View> hasTextInputLayoutHintText(final String expectedErrorText) {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof TextInputLayout)) {
                    return false;
                }

                CharSequence error = ((TextInputLayout) view).getError();

                if (error == null) {
                    return false;
                }

                String hint = error.toString();

                return expectedErrorText.equals(hint);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }

    @Test
    public void emailIsEmpty() {
        onView(withId(R.id.username_textInput)).perform(clearText());
        onView(withId(R.id.login_button)).perform(click());
        onView(withId(R.id.username_textLayout)).check(matches(hasTextInputLayoutHintText(getString(R.string.enter_valid_username))));
    }

    @Test
    public void passwordIsEmpty() {
        onView(withId(R.id.username_textInput)).perform(typeText("email@email.com"), closeSoftKeyboard());
        onView(withId(R.id.password_textInput)).perform(clearText());
        onView(withId(R.id.login_button)).perform(click());
        onView(withId(R.id.password_textLayout)).check(matches(hasTextInputLayoutHintText(getString(R.string.greater_than_5_characters))));
    }

    private String getString(@StringRes int resourceId) {
        return activityTestRule.getActivity().getString(resourceId);
    }
}