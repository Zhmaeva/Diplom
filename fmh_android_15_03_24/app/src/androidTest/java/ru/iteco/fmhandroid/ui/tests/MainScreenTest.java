package ru.iteco.fmhandroid.ui.tests;

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
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.LoadingSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования главного экрана")
public class MainScreenTest {
    LoadingSteps loadingSteps = new LoadingSteps();
    AuthSteps authSteps = new AuthSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void setup() {
        loadingSteps.checkLoadingScreen();
        authSteps.checkLoadingAuthPage();
        authSteps.successAuth();
    }

    @After
    public void teardown() {
        authSteps.clickBtnLogOut();
    }

    @Test
    @DisplayName("Проверка загрузки элементов главного экрана")
    public void checkingLoadingMainScreenTest() {
        mainSteps.checkLoadingMainPage();
    }

    @Test
    @DisplayName("Переход на страницу новостей с главного экрана")
    public void goingToNewsPageFromMainPage() {
        mainSteps.goToNewsPageFromMainPage();
        mainSteps.checkLoadingNewsPage();
    }

    @Test
    @DisplayName("Переход на страницу новостей с главного меню")
    public void goingToNewsPageFromMainMenu() {
        mainSteps.openMainMenu();
        mainSteps.goToNewsPageFromMainMenu();
        mainSteps.checkLoadingNewsPage();
    }


}
