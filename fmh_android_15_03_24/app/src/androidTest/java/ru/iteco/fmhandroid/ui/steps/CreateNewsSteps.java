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

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.pages.CreateNewsPage;

public class CreateNewsSteps {
    CreateNewsPage createNewsPage = new CreateNewsPage();
    DataGenerator dataGenerator = new DataGenerator();

    public void checkTitleCreateNews() {
        Allure.step("Проверка наличия заголовка Создание новости");
        ViewInteraction titleView = onView(createNewsPage.getTitlePage());
        titleView.check(matches(withText(dataGenerator.titlePageAddNews)));
    }

    public void selectCategory(String text) {
        Allure.step("Выбор категории для новой новости");
        ViewInteraction category = onView(createNewsPage.getCategory());
        category.perform(replaceText(text));
    }

    public void inputTitle(String text) {
        Allure.step("Заполнение поля заголовок");
        ViewInteraction title = onView(createNewsPage.getTitleInput());
        title.perform(replaceText(text));
    }

    public void selectDate(String text) {
        Allure.step("Выбор даты публикации");
        ViewInteraction date = onView(createNewsPage.getPublicationDateInput());
        date.perform(replaceText(text));
    }

    public void selectTime(String text) {
        Allure.step("Выбор времени публикации");
        ViewInteraction time = onView(createNewsPage.getPublicationTimeInput());
        time.perform(replaceText(text));
    }

    public void inputDescription(String text) {
        Allure.step("Заполнение поля описание");
        ViewInteraction description = onView(createNewsPage.getDescriptionInput());
        description.perform(replaceText(text));
    }

    public void switchStatus() {
        Allure.step("Переключение статуса публикации");
        ViewInteraction status = onView(createNewsPage.getStatusSwitch());
        status.perform(click());
    }

    public void clickSaveBtn() {
        Allure.step("Нажатие кнопки Сохранить");
        ViewInteraction saveBtn = onView(createNewsPage.getSaveBtn());
        saveBtn.perform(click());
    }

    public void clickCancelBtn() {
        Allure.step("Нажатие кнопки Отмена");
        ViewInteraction cancelBtn = onView(createNewsPage.getCancelBtn());
        cancelBtn.perform(click());
    }

    public void clickOkBtnInDialog() {
        Allure.step("Нажатие кнопки ОК в окне");
        ViewInteraction okBtn = onView(withText("OK"));
        okBtn.perform(click());
    }

    public void clickCancelBtnInDialog() {
        Allure.step("Нажатие кнопки отмена в окне");
        ViewInteraction cancelBtn = onView(withText("CANCEL"));
        cancelBtn.perform(click());
    }

    public void checkErrorMsg(String text, View decorView) {
        Allure.step("Проверка сообщения об ошибке по тексту");
        onView(withText(text))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    public void fillingFieldsToCreateNews(
            String category, String title, String date, String time, String description) {
        Allure.step("Заполнение полей для создания новости");
        selectCategory(category);
        inputTitle(title);
        selectDate(date);
        selectTime(time);
        inputDescription(description);
    }

    public void createAndSaveNews(
            String category, String title, String date, String time, String description) {
        Allure.step("Создание и сохранение новости");
        fillingFieldsToCreateNews(category, title, date, time, description);
        clickSaveBtn();
    }


}
