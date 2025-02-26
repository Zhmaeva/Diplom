package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.data.UIHelper;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.MainPage;

public class AboutSteps {
    MainPage mainPage = new MainPage();
    AboutPage aboutPage = new AboutPage();
    UIHelper uiHelper = new UIHelper();
    DataGenerator dataGenerator = new DataGenerator();

    public void clickBtnAbout() {
        Allure.step("Нажать на кнопку О приложении");
        uiHelper.elementWaiting(mainPage.mainTitle);
        onView(aboutPage.getMenuItemAbout())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void clickPrivacyPolicy() {
        Allure.step("Нажать на ссылку Политика конфиденциальности");
        uiHelper.elementWaiting(aboutPage.aboutPrivacyPolicy);
        onView(aboutPage.getAboutPrivacyPolicy())
                .check(
                        matches(
                                allOf(
                                        withText(dataGenerator.privacyPolicyLink),
                                        //withText(dataGenerator.truePrivacyPolicyLink),
                                        isDisplayed(),
                                        isClickable())));
    }

    public void clickTermsOfUse() {
        Allure.step("Нажать на ссылку Условия использования");
        uiHelper.elementWaiting(aboutPage.aboutTermsOfUse);
        onView(aboutPage.getAboutTermsOfUse())
                .check(
                        matches(
                                allOf(
                                        withText(dataGenerator.termsOfUseLink),
                                        //withText(dataGenerator.trueTermsOfUseLink),
                                        isDisplayed(),
                                        isClickable())));
    }

    public void checkVersion() {
        Allure.step("Проверка версии приложения");
        uiHelper.elementWaiting(aboutPage.aboutVersion);
        onView(aboutPage.getAboutVersion())
                .check(
                        matches(
                                allOf(
                                        withText(dataGenerator.version),
                                        isDisplayed())));
    }

}


