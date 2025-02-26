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
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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
@RunWith(AndroidJUnit4.class)

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

    @Before
    public void setup() {
        loadingSteps.checkLoadingScreen();
        authSteps.checkLoadingAuthPage();
        authSteps.successAuth();
        mainSteps.goToNewsPageFromMainPage();
        mainSteps.checkLoadingNewsPage();
        newsMainSteps.clickControlPanelBtn();
    }

    @After
    public void teardown() {
        authSteps.clickBtnLogOut();
    }

    // Создание новости в панели управления
    @Test
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

    // Нельзя создать новость с пустыми полями
    @Test
    public void createNewsWithEmptyFieldsTest() {
        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.clickSaveBtn();
        createNewsSteps.checkErrorMsg(dataGenerator.emptyFieldsMsg, decorView);
        pressBack();
    }

    // Отмена создания новости в панели управления
    @Test
    public void cancelCreateNewsTest() {
        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.clickCancelBtn();
        createNewsSteps.clickOkBtnInDialog();
    }

    // Удаление новости в панели управления
    @Test
    public void deleteNewsTest() {
        String category = randomCategory();
        String title = generateTitle();
        String publicationDate = generateFutureDate();
        String publicationTime = getCurrentTime();
        String description = generateDescription();

        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.createAndSaveNews(
                category, title, publicationDate, publicationTime, description);
        controlPanelNewsSteps.deleteNews(title);
        controlPanelNewsSteps.checkingNewsListWithoutSelectedText(title);
    }

    // Отмена удаления новости в панели управления
    @Test
    public void clickCancelDeleteNewsBtnTest() {
        String category = randomCategory();
        String title = generateTitle();
        String publicationDate = generateFutureDate();
        String publicationTime = getCurrentTime();
        String description = generateDescription();

        controlPanelNewsSteps.clickAddNewsBtn();
        createNewsSteps.createAndSaveNews(
                category, title, publicationDate, publicationTime, description);
        controlPanelNewsSteps.clickDeleteNewsBtn(title);
        createNewsSteps.clickCancelBtnInDialog();
        controlPanelNewsSteps.checkingNewsListWithText(title);
    }

    // Разворачивание описания новости в панели управления
    @Test
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

    // Редактирование новости в панели управления
    @Test
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

        controlPanelNewsSteps.deleteNews(newTitle);
    }

    // Смена статуса новости
    @Test
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

    // Отмена редактирования новости
    @Test
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

    // Нажатие на кнопку сортировка новостей в панели управления
    @Test
    public void sortNewsTest() {
        controlPanelNewsSteps.clickSortNewsBtn();
    }

    // Фильтрация новостей по категории в панели управления
    @Test
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
