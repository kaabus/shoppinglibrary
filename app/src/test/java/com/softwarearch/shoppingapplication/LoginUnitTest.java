package com.softwarearch.shoppingapplication;

import android.content.Context;

import com.softwarearch.shoppingapplication.view.activities.LoginActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(MockitoJUnitRunner.class)
public class LoginUnitTest {

    private static final String FAKE_STRING = "Login was successful";

    @Mock
    Context mMockContext;

    @Test
    public void readStringFromContext_LocalizedString() {

        LoginActivity myObjectUnderTest = new LoginActivity(mMockContext);

        // ...when the string is returned from the object under test...
        String result = myObjectUnderTest.checkPassword("user","user");

        // ...then the result should be the expected one.
        assertThat(result, is(FAKE_STRING));
    }

}
