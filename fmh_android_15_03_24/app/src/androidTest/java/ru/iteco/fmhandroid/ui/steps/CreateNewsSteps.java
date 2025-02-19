package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.pages.CreateNewsPage;

public class CreateNewsSteps {
    CreateNewsPage createNewsPage = new CreateNewsPage();
    DataGenerator dataGenerator = new DataGenerator();

    @Step("Проверка наличия заголовка Создание новости")
    public void checkTitleCreateNews() {
        ViewInteraction titleView = onView(createNewsPage.getTitlePage());
        titleView.check(matches(withText(dataGenerator.titlePageAddNews)));
    }

    @Step("Выбор категории для новой новости")
    public void selectCategory(String text) {
        ViewInteraction category = onView(createNewsPage.getCategory());
        category.perform(replaceText(text));
    }

    @Step("Заполнение поля заголовок")
    public void inputTitle(String text) {
        ViewInteraction title = onView(createNewsPage.getTitleInput());
        title.perform(replaceText(text));
    }

    @Step("Выбор даты публикации")
    public void selectDate(String text) {
        ViewInteraction date = onView(createNewsPage.getPublicationDateInput());
        date.perform(replaceText(text));
    }

    @Step("Выбор времени публикации")
    public void selectTime(String text) {
        ViewInteraction time = onView(createNewsPage.getPublicationTimeInput());
        time.perform(replaceText(text));
    }

    @Step("Заполнение поля описание")
    public void inputDescription(String text) {
        ViewInteraction description = onView(createNewsPage.getDescriptionInput());
        description.perform(replaceText(text));
    }

    @Step("Переключение статуса публикации")
    public void switchStatus() {
        ViewInteraction status = onView(createNewsPage.getStatusSwitch());
        status.perform(click());
    }

    @Step("Нажатие кнопки Сохранить")
    public void clickSaveBtn() {
        ViewInteraction saveBtn = onView(createNewsPage.getSaveBtn());
        saveBtn.perform(click());
    }

    @Step("Нажатие кнопки Отмена")
    public void clickCancelBtn() {
        ViewInteraction cancelBtn = onView(createNewsPage.getCancelBtn());
        cancelBtn.perform(click());
    }

    @Step("Нажатие кнопки ОК в окне")
    public void clickOkBtnInDialog() {
        ViewInteraction okBtn = onView(withText("OK"));
        okBtn.perform(click());
    }

    @Step("Нажатие кнопки отмена в окне")
    public void clickCancelBtnInDialog() {
        ViewInteraction cancelBtn = onView(withText("CANCEL"));
        cancelBtn.perform(click());
    }

    @Step("Проверка сообщения об ошибке по тексту")
    public void checkErrorMsg(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Step("Заполнение полей для создания новости")
    public void fillingFieldsToCreateNews(
            String category, String title, String date, String time, String description) {
        selectCategory(category);
        inputTitle(title);
        selectDate(date);
        selectTime(time);
        inputDescription(description);
    }

    @Step("Создание и сохранение новости")
    public void createAndSaveNews(
            String category, String title, String date, String time, String description) {
        fillingFieldsToCreateNews(category, title, date, time, description);
        clickSaveBtn();
    }


}
