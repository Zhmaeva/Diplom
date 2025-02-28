package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Issue;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
//@RunWith(AndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования экрана О приложении")
public class AboutScreenTest {
    AuthSteps authSteps = new AuthSteps();
    MainSteps mainSteps = new MainSteps();
    AboutSteps aboutSteps = new AboutSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void setup() {
        authSteps.checkLoadingAuthPage();
        authSteps.successAuth();
        mainSteps.checkLoadingMainPage();
        mainSteps.openMainMenu();
        aboutSteps.clickBtnAbout();
    }

    @After
    public void tearDown() {
        authSteps.clickBtnLogOut();
    }

    @Test
    @Issue("https://github.com/Zhmaeva/Diplom/issues/6")
    @DisplayName("Проверка ссылки Политика конфиденциальности")
    public void checkPrivacyPoliceInAboutPage() {
        aboutSteps.clickPrivacyPolicy();
        pressBack();
    }

    @Test
    @Issue("https://github.com/Zhmaeva/Diplom/issues/7")
    @DisplayName("Проверка ссылки Пользовательское соглашение")
    public void checkTermOfUseInAboutPage() {
        aboutSteps.clickTermsOfUse();
        pressBack();
    }

    @Test
    @DisplayName("Проверка версии приложения")
    public void checkVersionInAboutPage() {
        aboutSteps.checkVersion();
        pressBack();
    }

}
