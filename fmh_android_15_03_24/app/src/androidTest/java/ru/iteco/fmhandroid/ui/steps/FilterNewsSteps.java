package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.pages.FilterNewsPage;

public class FilterNewsSteps {
    FilterNewsPage filterNewsPage = new FilterNewsPage();

    public void checkTitleFilterNews() {
        Allure.step("Проверка наличия заголовка Фильтровать новости");
        onView(filterNewsPage.getTitle()).check(matches(isDisplayed()));
    }

    public void clickFilterBtn() {
        Allure.step("Нажатие на кнопку фильтровать");
        onView(filterNewsPage.getFilterBtn()).perform(click());
    }

    public void clickCancelBtn() {
        Allure.step("Нажатие на кнопку Отмена");
        onView(filterNewsPage.getCancelBtn()).perform(click());
    }

    public void inputStartDate(String date) {
        Allure.step("Ввод начальной даты");
        onView(filterNewsPage.getDateStart()).perform(replaceText(date));
    }

    public void inputEndDate(String date) {
        Allure.step("Ввод конечной даты");
        onView(filterNewsPage.getDateEnd()).perform(replaceText(date));
    }

    public void clickActiveCheckBox() {
        Allure.step("Нажатие на чекбокс Активна");
        onView(filterNewsPage.getActiveCheckBox()).perform(click());
    }

    public void clickNotActiveCheckBox() {
        Allure.step("Нажатие на чекбокс Не Активна");
        onView(filterNewsPage.getNotActiveCheckBox()).perform(click());
    }

    public void filterNewsByCategory(String category) {
        Allure.step("Фильтрация новостей по полю категория");
        ViewInteraction categoryField = onView(filterNewsPage.getCategory());
        categoryField.perform(replaceText(category));
    }


}
