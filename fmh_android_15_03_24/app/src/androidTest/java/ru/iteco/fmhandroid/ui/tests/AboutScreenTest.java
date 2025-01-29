package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class AboutScreenTest {
    AuthSteps authSteps = new AuthSteps();
    MainSteps mainSteps = new MainSteps();
    AboutSteps aboutSteps = new AboutSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

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

    // Проверка ссылки Политика конфиденциальности
    @Test
    public void checkPrivacyPoliceInAboutPage() {
        aboutSteps.clickPrivacyPolicy();
        pressBack();
    }

    // Проверка ссылки Пользовательское соглашение
    @Test
    public void checkTermOfUseInAboutPage() {
        aboutSteps.clickTermsOfUse();
        pressBack();
    }

    // Проверка версии приложения
    @Test
    public void checkVersionInAboutPage() {
        aboutSteps.checkVersion();
        pressBack();
    }

}
