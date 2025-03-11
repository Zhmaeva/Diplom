package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

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
import ru.iteco.fmhandroid.ui.steps.ControlPanelNewsSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsMainSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования главного экрана новостей")
public class NewsMainScreenTest {
    AuthSteps authSteps = new AuthSteps();
    MainSteps mainSteps = new MainSteps();
    NewsMainSteps newsMainSteps = new NewsMainSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    ControlPanelNewsSteps controlPanelNewsSteps = new ControlPanelNewsSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void setup() {
        try {
            mainSteps.checkLoadingMainPage();
            mainSteps.goToNewsPageFromMainPage();
            mainSteps.checkLoadingNewsPage();
        } catch (Exception e) {
            authSteps.checkLoadingAuthPage();
            authSteps.successAuth();
            mainSteps.goToNewsPageFromMainPage();
        }
    }

    @Test
    @DisplayName("Нажатие кнопки сортировка новостей")
    public void clickSortNewsBtnTest() {
        newsMainSteps.clickSortNewsBtn();
    }

    @Test
    @DisplayName("Нажатие кнопки фильтр новостей")
    public void goToTheNewsFilteringScreenTest() {
        newsMainSteps.clickFilterNewsBtn();
        filterNewsSteps.checkTitleFilterNews();
        pressBack();
    }

    @Test
    @DisplayName("Нажатие кнопки панель управления новостями")
    public void goToTheNewsControlPanelTest() {
        newsMainSteps.clickControlPanelBtn();
        controlPanelNewsSteps.checkTitleControlPanel();
        pressBack();
    }

}
