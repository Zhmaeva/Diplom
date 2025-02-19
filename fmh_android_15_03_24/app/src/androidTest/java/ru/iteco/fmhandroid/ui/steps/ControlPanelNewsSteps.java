package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pages.ControlPanelNewsPage;

public class ControlPanelNewsSteps {
    ControlPanelNewsPage controlPanel = new ControlPanelNewsPage();
    CreateNewsSteps createNewsSteps = new CreateNewsSteps();

    @Step("Проверка наличия заголовка Панель управления")
    public void checkTitleControlPanel() {
        onView(controlPanel.getTitle()).check(matches(isDisplayed()));
    }

    @Step("Нажатие на кнопку сортировка новостей")
    public void clickSortNewsBtn() {
        onView(controlPanel.getSortNewsBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Step("Нажатие на кнопку фильтр новостей")
    public void clickFilterNewsBtn() {
        onView(controlPanel.getFilterNewsBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Step("Нажатие на кнопку добавить новость")
    public void clickAddNewsBtn() {
        onView(controlPanel.getAddNewsBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Step("Нажатие на кнопку удалить новость")
    public void clickDeleteNewsBtn(String newsTitle) {
        onView(controlPanel.deleteNewsWithTitle(newsTitle))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Step("Нажатие на кнопку редактировать новость")
    public void clickEditNewsBtn(String newsTitle) {
        onView(controlPanel.editNewsWithTitle(newsTitle))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Step("Нажатие на кнопку просмотреть новость")
    public void clickViewNewsBtn(String title) {
        onView(controlPanel.getViewNewsBtn(title))
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Step("Получение описания новости")
    public void getDescriptionNews(String title) {
        onView(controlPanel.getDescriptionNews(title))
                .check(matches(isDisplayed()));
    }

    @Step("Проверка наличия новостей в списке с выбранным названием")
    public void checkingNewsListWithText(String text) {
        onView(allOf(
                withText(text), isDisplayed()))
                .check(matches(isDisplayed()));
    }

    @Step("Проверка отсутствия новостей с выбранным названием")
    public void checkingNewsListWithoutSelectedText(String text) {
        onView(allOf(withText(text), isDisplayed())).check(doesNotExist());
    }

    @Step("Проверка статуса новости")
    public void checkingNewsStatus(String title, String status) {
        onView(controlPanel.getNewsStatus(title))
                .check(matches(isDisplayed()))
                .check(matches(withText(status)));
    }

    @Step("Удаление созданной новости")
    public void deleteNews(String title) {
        clickDeleteNewsBtn(title);
        createNewsSteps.clickOkBtnInDialog();
    }


}
