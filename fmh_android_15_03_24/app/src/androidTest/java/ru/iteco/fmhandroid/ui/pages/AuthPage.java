package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.UIHelper;

public class AuthPage {
    UIHelper uiHelper = new UIHelper();

    public int loginFieldId = R.id.login_text_input_layout;
    public int passwordFieldId = R.id.password_text_input_layout;
    public int btnEnterId = R.id.enter_button;
    public int authorizationBtnId = R.id.authorization_image_button;
    public int logOutId = android.R.id.title;


    public Matcher<View> getTitle() {
        return allOf(
                withText("Authorization"),
                withParent(withParent(withId(R.id.nav_host_fragment)))
        );
    }

    public Matcher<View> getLoginField() {
        return allOf(
                isDescendantOfA(withId(loginFieldId)),
                withClassName(endsWith("EditText"))
        );
    }

    public Matcher<View> getPasswordField() {
        return allOf(
                isDescendantOfA(withId(R.id.password_text_input_layout)),
                withClassName(endsWith("EditText"))
        );
    }

    public Matcher<View> getLogOutBtn() {
        uiHelper.elementWaiting(logOutId);
        return allOf(
                withId(logOutId),
                withText("Log out"),
                childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        0)
        );
    }

    public Matcher<View> getAuthorizationBtn() {
        uiHelper.elementWaiting(authorizationBtnId);
        return allOf(
                withId(authorizationBtnId),
                withContentDescription("Authorization")
        );
    }


    // childAtPosition
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}



