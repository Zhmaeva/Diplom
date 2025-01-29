package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.data.UIHelper;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;

public class AboutSteps {
    MainPage mainPage = new MainPage();
    AboutPage aboutPage = new AboutPage();
    UIHelper uiHelper = new UIHelper();
    DataGenerator dataGenerator = new DataGenerator();

    @Step("Нажать на кнопку О приложении")
    public void clickBtnAbout() {
        uiHelper.elementWaiting(mainPage.mainTitle);
        onView(aboutPage.getMenuItemAbout())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Step("Нажать на ссылку Политика конфиденциальности")
    public void clickPrivacyPolicy() {
        uiHelper.elementWaiting(aboutPage.aboutPrivacyPolicy);
        onView(aboutPage.getAboutPrivacyPolicy())
                .check(
                        matches(
                                allOf(
                                        withText(dataGenerator.privacyPolicyLink),
                                        isDisplayed(),
                                        isClickable())));
    }

    @Step("Нажать на ссылку Условия использования")
    public void clickTermsOfUse() {
        uiHelper.elementWaiting(aboutPage.aboutTermsOfUse);
        onView(aboutPage.getAboutTermsOfUse())
                .check(
                        matches(
                                allOf(
                                        withText(dataGenerator.termsOfUseLink),
                                        isDisplayed(),
                                        isClickable())));
    }

    @Step("Проверка версии приложения")
    public void checkVersion() {
        uiHelper.elementWaiting(aboutPage.aboutVersion);
        onView(aboutPage.getAboutVersion())
                .check(
                        matches(
                                allOf(
                                        withText(dataGenerator.version),
                                        isDisplayed())));
    }

}


