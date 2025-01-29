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

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.UIHelper;
import ru.iteco.fmhandroid.ui.pages.MainPage;

public class MainSteps {
    private final MainPage mainPage = new MainPage();
    UIHelper uiHelper = new UIHelper();

    @Step("Проверка загрузки главного экрана")
    public void checkLoadingMainPage() {
        onView(mainPage.getMainMenuBtn()).check(matches(isDisplayed()));
        onView(mainPage.getTrademarkImageView()).check(matches(isDisplayed()));
        onView(mainPage.getOurMissionImageButton()).check(matches(isDisplayed()));
        onView(mainPage.getAuthorizationImageButton()).check(matches(isDisplayed()));
        onView(mainPage.getNewsContainer()).check(matches(isDisplayed()));
    }

    @Step("Переход на страницу новости с главного экрана")
    public void goToNewsPageFromMainPage() {
        ViewInteraction allNewsLink = onView(mainPage.getAllNewsLink()).check(matches(isDisplayed()));
        allNewsLink.perform(click());
    }

    @Step("Проверка загрузки страницы Новости")
    public void checkLoadingNewsPage() {
        ViewInteraction newsTitle = onView(allOf(
                withText("News"),
                withParent(withParent(withId(R.id.container_list_news_include))),
                isDisplayed()));
        newsTitle.check(matches(withText("News")));
    }

    @Step("Открытие главного меню (бургер")
    public void openMainMenu() {
        onView(mainPage.getMainMenuBtn()).perform(click());
    }

    @Step("Переход на страницу новости с главного меню")
    public void goToNewsPageFromMainMenu() {
        uiHelper.elementWaiting(mainPage.mainTitle);
        onView(mainPage.getMenuItemNews())
                .check(matches(isDisplayed()))
                .perform(click());

    }
}
