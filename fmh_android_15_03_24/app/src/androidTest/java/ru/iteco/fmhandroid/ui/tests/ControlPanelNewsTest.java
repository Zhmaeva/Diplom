package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.pressBack;
import static ru.iteco.fmhandroid.ui.data.DataGenerator.RandomCategory.randomCategory;
import static ru.iteco.fmhandroid.ui.data.DataGenerator.generateDescription;
import static ru.iteco.fmhandroid.ui.data.DataGenerator.generateFutureDate;
import static ru.iteco.fmhandroid.ui.data.DataGenerator.generateTitle;
import static ru.iteco.fmhandroid.ui.data.DataGenerator.getCurrentDate;
import static ru.iteco.fmhandroid.ui.data.DataGenerator.getCurrentTime;

import android.view.View;

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
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelNewsSteps;
import ru.iteco.fmhandroid.ui.steps.CreateNewsSteps;
import ru.iteco.fmhandroid.ui.steps.FilterNewsSteps;
import ru.iteco.fmhandroid.ui.steps.LoadingSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsMainSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования панели управления новостями")
public class ControlPanelNewsTest {
    private View decorView;
    DataGenerator dataGenerator = new DataGenerator();
    LoadingSteps loadingSteps = new LoadingSteps();
    AuthSteps authSteps = new AuthSteps();
    MainSteps mainSteps = new MainSteps();
    NewsMainSteps newsMainSteps = new NewsMainSteps();
    FilterNewsSteps filterNewsSteps = new FilterNewsSteps();
    ControlPanelNewsSteps controlPanelNewsSteps = new ControlPanelNewsSteps();
    CreateNewsSteps createNewsSteps = new CreateNewsSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void setup() {
        loadingSteps.checkLoadingScreen();
        try {
            mainSteps.goToNewsPageFromMainPage();
            mainSteps.checkLoadingNewsPage();
            newsMainSteps.clickControlPanelBtn();
        } catch (Exception e) {
            authSteps.checkLoadingAuthPage();
            authSteps.successAuth();
            mainSteps.goToNewsPageFromMainPage();
            newsMainSteps.clickControlPanelBtn();
        }
    }

    @Test
    @DisplayName("Создание новости в панели управления")
    public void createNewsTest() {
        String category = randomCategory();
        String title = generateTitle();
        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String description = generateDescription();

        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.checkTitleCreateNews();
        createNewsSteps.createAndSaveNews(
                category, title, publicationDate, publicationTime, description);
        controlPanelNewsSteps.checkingNewsListWithText(title);
    }

    @Test
    @DisplayName("Нельзя создать новость с пустыми полями")
    public void createNewsWithEmptyFieldsTest() {
        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.clickSaveBtn();
        createNewsSteps.checkErrorMsg(dataGenerator.emptyFieldsMsg, decorView);
        pressBack();
    }

    @Test
    @DisplayName("Отмена создания новости в панели управления")
    public void cancelCreateNewsTest() {
        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.clickCancelBtn();
        createNewsSteps.clickOkBtnInDialog();
    }

    @Test
    @DisplayName("Удаление новости в панели управления")
    public void deleteNewsTest() {
        String category = randomCategory();
        String title = generateTitle();
        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String description = generateDescription();

        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.createAndSaveNews(
                category, title, publicationDate, publicationTime, description);
        controlPanelNewsSteps.deleteNews(title);
        controlPanelNewsSteps.checkingNewsListWithoutSelectedText(title);
    }

    @Test
    @DisplayName("Отмена удаления новости в панели управления")
    public void clickCancelDeleteNewsBtnTest() {
        String category = randomCategory();
        String title = generateTitle();
        String publicationDate = getCurrentDate();
        String publicationTime = getCurrentTime();
        String description = generateDescription();

        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.createAndSaveNews(
                category, title, publicationDate, publicationTime, description);
        controlPanelNewsSteps.clickDeleteNewsBtn(title);
        createNewsSteps.clickCancelBtnInDialog();
        controlPanelNewsSteps.checkingNewsListWithText(title);
    }

    @Test
    @DisplayName("Разворачивание описания новости в панели управления")
    public void clickViewNewsBtnTest() {
        String category = randomCategory();
        String title = generateTitle();
        String publicationDate = generateFutureDate();
        String publicationTime = getCurrentTime();
        String description = generateDescription();

        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.createAndSaveNews(
                category, title, publicationDate, publicationTime, description);
        controlPanelNewsSteps.clickViewNewsBtn(title);
        controlPanelNewsSteps.getDescriptionNews(description);
    }

    @Test
    @DisplayName("Редактирование новости в панели управления")
    public void editNewsTest() {
        String category = randomCategory();
        String title = generateTitle();
        String publicationDate = generateFutureDate();
        String publicationTime = getCurrentTime();
        String description = generateDescription();

        String newCategory = randomCategory();
        String newTitle = "Привет! Я новый заголовок";
        String newPublicationDate = getCurrentDate();
        String newPublicationTime = getCurrentTime();
        String newDescription = "Новое описание новости";

        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.createAndSaveNews(
                category, title, publicationDate, publicationTime, description);

        controlPanelNewsSteps.clickEditNewsBtn(title);
        createNewsSteps.fillingFieldsToCreateNews(
                newCategory, newTitle, newPublicationDate, newPublicationTime, newDescription);
        createNewsSteps.clickSaveBtn();
        controlPanelNewsSteps.checkingNewsListWithText(newTitle);
    }

    @Test
    @DisplayName("Смена статуса новости в панели управления")
    public void changeStatusNewsTest() {
        String category = randomCategory();
        String title = generateTitle();
        String publicationDate = generateFutureDate();
        String publicationTime = getCurrentTime();
        String description = generateDescription();

        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.createAndSaveNews(
                category, title, publicationDate, publicationTime, description);

        controlPanelNewsSteps.clickEditNewsBtn(title);
        createNewsSteps.switchStatus();
        createNewsSteps.clickSaveBtn();
        controlPanelNewsSteps.checkingNewsStatus(title, "NOT ACTIVE");
    }

    @Test
    @DisplayName("Отмена редактирования новости в панели управления")
    public void cancelEditNewsTest() {
        String category = randomCategory();
        String title = generateTitle();
        String publicationDate = generateFutureDate();
        String publicationTime = getCurrentTime();
        String description = generateDescription();

        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.createAndSaveNews(
                category, title, publicationDate, publicationTime, description);

        controlPanelNewsSteps.clickEditNewsBtn(title);
        createNewsSteps.clickCancelBtn();
        createNewsSteps.clickOkBtnInDialog();
        controlPanelNewsSteps.checkingNewsListWithText(title);
    }

    @Test
    @DisplayName("Сортировка новостей в панели управления")
    public void sortNewsTest() {
        controlPanelNewsSteps.clickSortNewsBtn();
    }

    @Test
    @DisplayName("Фильтрация новостей по категории в панели управления")
    public void filterNewsByCategoryTest() {
        String category = randomCategory();
        String title = generateTitle();
        String publicationDate = generateFutureDate();
        String publicationTime = getCurrentTime();
        String description = generateDescription();

        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.createAndSaveNews(
                category, title, publicationDate, publicationTime, description);

        controlPanelNewsSteps.clickFilterNewsBtn();
        filterNewsSteps.filterNewsByCategory(category);
        filterNewsSteps.clickFilterBtn();
    }

}
