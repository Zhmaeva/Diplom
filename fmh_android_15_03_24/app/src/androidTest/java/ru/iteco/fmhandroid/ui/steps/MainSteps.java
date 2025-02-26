package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.UIHelper;
import ru.iteco.fmhandroid.ui.pages.MainPage;

public class MainSteps {
    private final MainPage mainPage = new MainPage();
    UIHelper uiHelper = new UIHelper();

    public void checkLoadingMainPage() {
        Allure.step("Проверка загрузки главного экрана");
        onView(mainPage.getMainMenuBtn()).check(matches(isDisplayed()));
        onView(mainPage.getTrademarkImageView()).check(matches(isDisplayed()));
        onView(mainPage.getOurMissionImageButton()).check(matches(isDisplayed()));
        onView(mainPage.getAuthorizationImageButton()).check(matches(isDisplayed()));
        onView(mainPage.getNewsContainer()).check(matches(isDisplayed()));
    }

    public void goToNewsPageFromMainPage() {
        Allure.step("Переход на страницу новости с главного экрана");
        ViewInteraction allNewsLink = onView(mainPage.getAllNewsLink()).check(matches(isDisplayed()));
        allNewsLink.perform(click());
    }

    public void checkLoadingNewsPage() {
        Allure.step("Проверка загрузки страницы Новости");
        ViewInteraction newsTitle = onView(allOf(
                withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))),
                isDisplayed()));
        newsTitle.check(matches(withText("News")));
    }

    public void openMainMenu() {
        Allure.step("Открытие главного меню (бургер");
        onView(mainPage.getMainMenuBtn()).perform(click());
    }

    public void goToNewsPageFromMainMenu() {
        Allure.step("Переход на страницу новости с главного меню");
        uiHelper.elementWaiting(mainPage.mainTitle);
        onView(mainPage.getMenuItemNews())
                .check(matches(isDisplayed()))
                .perform(click());
    }
}
