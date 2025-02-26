package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.pages.ControlPanelNewsPage;

public class ControlPanelNewsSteps {
    ControlPanelNewsPage controlPanel = new ControlPanelNewsPage();
    CreateNewsSteps createNewsSteps = new CreateNewsSteps();

    public void checkTitleControlPanel() {
        Allure.step("Проверка наличия заголовка Панель управления");
        onView(controlPanel.getTitle()).check(matches(isDisplayed()));
    }

    public void clickSortNewsBtn() {
        Allure.step("Нажатие на кнопку сортировка новостей");
        onView(controlPanel.getSortNewsBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void clickFilterNewsBtn() {
        Allure.step("Нажатие на кнопку фильтр новостей");
        onView(controlPanel.getFilterNewsBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void clickAddNewsBtn() {
        Allure.step("Нажатие на кнопку добавить новость");
        onView(controlPanel.getAddNewsBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void clickDeleteNewsBtn(String newsTitle) {
        Allure.step("Нажатие на кнопку удалить новость");
        onView(controlPanel.deleteNewsWithTitle(newsTitle))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void clickEditNewsBtn(String newsTitle) {
        Allure.step("Нажатие на кнопку редактировать новость");
        onView(controlPanel.editNewsWithTitle(newsTitle))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void clickViewNewsBtn(String title) {
        Allure.step("Нажатие на кнопку просмотреть новость");
        onView(controlPanel.getViewNewsBtn(title))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void getDescriptionNews(String title) {
        Allure.step("Получение описания новости");
        onView(controlPanel.getDescriptionNews(title))
                .check(matches(isDisplayed()));
    }

    public void checkingNewsListWithText(String text) {
        Allure.step("Проверка наличия новостей в списке с выбранным названием");
        onView(allOf(
                withText(text), isDisplayed()))
                .check(matches(isDisplayed()));
    }

    public void checkingNewsListWithoutSelectedText(String text) {
        Allure.step("Проверка отсутствия новостей с выбранным названием");
        onView(allOf(withText(text), isDisplayed())).check(doesNotExist());
    }

    public void checkingNewsStatus(String title, String status) {
        Allure.step("Проверка статуса новости");
        onView(controlPanel.getNewsStatus(title))
                .check(matches(isDisplayed()))
                .check(matches(withText(status)));
    }

    public void deleteNews(String title) {
        Allure.step("Удаление созданной новости");
        clickDeleteNewsBtn(title);
        createNewsSteps.clickOkBtnInDialog();
    }


}
