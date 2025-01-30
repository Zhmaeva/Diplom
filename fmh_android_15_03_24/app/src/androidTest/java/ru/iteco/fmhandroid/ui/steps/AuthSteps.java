package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

import android.view.View;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.data.UIHelper;
import ru.iteco.fmhandroid.ui.pages.AuthPage;


public class AuthSteps {
    private final AuthPage authPage = new AuthPage();
    UIHelper uiHelper = new UIHelper();
    DataGenerator dataGenerator = new DataGenerator();

    @Step("Проверка загрузки экрана авторизации")
    public void checkLoadingAuthPage() {
        uiHelper.elementWaiting(authPage.loginFieldId);
        uiHelper.elementWaiting(authPage.passwordFieldId);
        uiHelper.elementWaiting(authPage.btnEnterId);

        onView(authPage.getLoginField()).check(matches(isCompletelyDisplayed()));
        onView(authPage.getPasswordField()).check(matches(isDisplayed()));
    }

    @Step("Ввод логина")
    public void inputLogin(String login) {
        onView(authPage.getLoginField()).perform(typeText(login), closeSoftKeyboard());
    }

    @Step("Ввод пароля")
    public void inputPassword(String password) {
        onView(authPage.getPasswordField()).perform(typeText(password), closeSoftKeyboard());
    }

    @Step("Нажатие на кнопку войти")
    public void clickBtnEnter() {
        uiHelper.elementWaiting(authPage.btnEnterId);
        onView(withId(authPage.btnEnterId)).perform(click());
    }

    @Step("Нажатие на кнопку выход")
    public void clickBtnLogOut() {
        onView(authPage.getAuthorizationBtn()).perform(click());
        onView(authPage.getLogOutBtn()).perform(click());
    }

    @Step("Проверка выхода из аккаунта")
    public void checkLogOut() {
        uiHelper.elementWaiting(authPage.loginFieldId);
        onView(authPage.getTitle()).check(matches(isDisplayed()));
    }

    @Step("Проверка входа в аккаунт")
    public void checkLogIn() {
        uiHelper.elementWaiting(authPage.authorizationBtnId);
        onView(withId(authPage.authorizationBtnId)).check(matches(isDisplayed()));
    }

    @Step("Успешная авторизация")
    public void successAuth() {
        inputLogin(dataGenerator.login);
        inputPassword(dataGenerator.password);
        clickBtnEnter();
    }

    public void checkAuthError(String exception, View decorView) {
        Allure.step("Проверка сообщения об ошибке по тексту");
        onView(withText(exception))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
}

