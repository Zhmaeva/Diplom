package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.UIHelper;


public class AboutPage {
    MainPage mainPage = new MainPage();
    UIHelper uiHelper = new UIHelper();

    public int aboutPrivacyPolicy = R.id.about_privacy_policy_value_text_view;
    public int aboutTermsOfUse = R.id.about_terms_of_use_value_text_view;
    public int aboutVersion = R.id.about_version_value_text_view;

    public Matcher<View> getMenuItemAbout() {
        uiHelper.elementWaiting(mainPage.mainTitle);
        return allOf(
                withId(mainPage.mainTitle),
                withText("About")
        );
    }

    public Matcher<View> getAboutPrivacyPolicy() {
        uiHelper.elementWaiting(aboutPrivacyPolicy);
        return withId(aboutPrivacyPolicy);
    }

    public Matcher<View> getAboutTermsOfUse() {
        uiHelper.elementWaiting(aboutTermsOfUse);
        return withId(aboutTermsOfUse);
    }

    public Matcher<View> getAboutVersion() {
        uiHelper.elementWaiting(aboutVersion);
        return withId(aboutVersion);
    }


}
