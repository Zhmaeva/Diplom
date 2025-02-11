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
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelNewsSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.LoadingSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsMainSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class NewsMainScreenTest {
    LoadingSteps loadingSteps = new LoadingSteps();
    AuthSteps authSteps = new AuthSteps();
    MainSteps mainSteps = new MainSteps();
    NewsMainSteps newsMainSteps = new NewsMainSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    ControlPanelNewsSteps controlPanelNewsSteps = new ControlPanelNewsSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setup() {
        loadingSteps.checkLoadingScreen();
        authSteps.checkLoadingAuthPage();
        authSteps.successAuth();
        mainSteps.goToNewsPageFromMainPage();
        mainSteps.checkLoadingNewsPage();
    }

    @After
    public void teardown() {
        authSteps.clickBtnLogOut();
    }

    // Наличие кнопки сортировка новостей(*новости не отображаются!)
    @Test
    public void clickSortNewsBtnTest() {
        newsMainSteps.clickSortNewsBtn();
    }

    // Нажатие кнопки фильтр новостей
    @Test
    public void  goToTheNewsFilteringScreenTest() {
        newsMainSteps.clickFilterNewsBtn();
        filterNewsSteps.checkTitleFilterNews();
        pressBack();
    }

    // Нажатие кнопки панель управления новостями
    @Test
    public void  goToTheNewsControlPanelTest() {
        newsMainSteps.clickControlPanelBtn();
        controlPanelNewsSteps.checkTitleControlPanel();
        pressBack();
    }

}
