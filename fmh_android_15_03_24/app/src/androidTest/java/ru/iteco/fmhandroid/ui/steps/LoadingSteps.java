package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.UIHelper;
import ru.iteco.fmhandroid.ui.pages.LoadingPage;

public class LoadingSteps {
    private final LoadingPage loadingPage = new LoadingPage();

    public void checkLoadingScreen() {
        Allure.step("Проверка загрузки приложения");
        UIHelper uiHelper = new UIHelper();
        uiHelper.elementWaiting(loadingPage.imageId);
        uiHelper.elementWaiting(loadingPage.textId);
        uiHelper.elementWaiting(loadingPage.progressId);

        onView(loadingPage.getImage()).check(matches(isDisplayed()));
        onView(loadingPage.getText()).check(matches(isDisplayed()));
        onView(loadingPage.getProgress()).check(matches(isDisplayed()));
    }
}
