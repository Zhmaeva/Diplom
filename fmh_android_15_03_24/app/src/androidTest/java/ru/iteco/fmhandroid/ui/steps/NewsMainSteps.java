package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.pages.NewsMainPage;

public class NewsMainSteps {
    NewsMainPage newsMainPage = new NewsMainPage();

    public void clickSortNewsBtn() {
        Allure.step("Нажатие на кнопку сортировка новостей");
        onView(newsMainPage.getSortNewsBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void clickFilterNewsBtn() {
        Allure.step("Нажатие на кнопку фильтр новостей");
        onView(newsMainPage.getFilterNewsBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    public void clickControlPanelBtn() {
        Allure.step("Нажатие на кнопку панель управления новостями");
        onView(newsMainPage.getControlPanelBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }
}
