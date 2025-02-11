package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.pages.NewsMainPage;

public class NewsMainSteps {
    NewsMainPage newsMainPage = new NewsMainPage();

    @Step("Нажатие на кнопку сортировка новостей")
    public void clickSortNewsBtn() {
        onView(newsMainPage.getSortNewsBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Step("Нажатие на кнопку фильтр новостей")
    public void clickFilterNewsBtn() {
        onView(newsMainPage.getFilterNewsBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    @Step("Нажатие на кнопку панель управления новостями")
    public void clickControlPanelBtn() {
        onView(newsMainPage.getControlPanelBtn())
                .check(matches(isDisplayed()))
                .perform(click());
    }
}
