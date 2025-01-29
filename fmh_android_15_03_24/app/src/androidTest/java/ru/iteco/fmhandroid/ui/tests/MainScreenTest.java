package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.LoadingSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class MainScreenTest {
    LoadingSteps loadingSteps = new LoadingSteps();
    AuthSteps authSteps = new AuthSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

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

    // Проверка загрузки элементов главного экрана
    @Test
    public void checkingLoadingMainScreenTest() {
        mainSteps.checkLoadingMainPage();
    }

    // Переход на страницу новости с главного экрана
    @Test
    public void goingToNewsPageFromMainPage() {
        mainSteps.goToNewsPageFromMainPage();
        mainSteps.checkLoadingNewsPage();
    }

    // Переход на страницу новости с главного меню
    @Test
    public void goingToNewsPageFromMainMenu() {
        mainSteps.openMainMenu();
        mainSteps.goToNewsPageFromMainMenu();
        mainSteps.checkLoadingNewsPage();
    }


}
