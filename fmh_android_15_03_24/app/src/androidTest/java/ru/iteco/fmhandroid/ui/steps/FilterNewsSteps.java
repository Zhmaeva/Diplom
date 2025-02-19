package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pages.FilterNewsPage;

public class FilterNewsSteps {
    FilterNewsPage filterNewsPage = new FilterNewsPage();

    @Step("Проверка наличия заголовка Фильтровать новости")
    public void checkTitleFilterNews() {
        onView(filterNewsPage.getTitle()).check(matches(isDisplayed()));
    }

//    @Step("Проверка наличия всех элементов на странице")
//    public void checkAllElementsInFilterNews() {
//        onView(filterNewsPage.getTitle()).check(matches(isDisplayed()));
//        onView(filterNewsPage.getCategory()).check(matches(isDisplayed()));
//        onView(filterNewsPage.getDateStart()).check(matches(isDisplayed()));
//        onView(filterNewsPage.getDateEnd()).check(matches(isDisplayed()));
////        onView(filterNewsPage.getActiveCheckBox()).check(matches(isDisplayed()));
////        onView(filterNewsPage.getNotActiveCheckBox()).check(matches(isDisplayed()));
//        onView(filterNewsPage.getFilterBtn()).check(matches(isDisplayed()));
//        onView(filterNewsPage.getCancelBtn()).check(matches(isDisplayed()));
//    }


}
