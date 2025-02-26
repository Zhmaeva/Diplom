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
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.data.UIHelper;
import ru.iteco.fmhandroid.ui.pages.AuthPage;


public class AuthSteps {
    private final AuthPage authPage = new AuthPage();
    UIHelper uiHelper = new UIHelper();
    DataGenerator dataGenerator = new DataGenerator();

    public void checkLoadingAuthPage() {
        Allure.step("Проверка загрузки экрана авторизации");
        uiHelper.elementWaiting(authPage.loginFieldId);
        uiHelper.elementWaiting(authPage.passwordFieldId);
        uiHelper.elementWaiting(authPage.btnEnterId);

        onView(authPage.getLoginField()).check(matches(isCompletelyDisplayed()));
        onView(authPage.getPasswordField()).check(matches(isDisplayed()));
    }

    public void inputLogin(String login) {
        Allure.step("Ввод логина");
        onView(authPage.getLoginField()).perform(typeText(login), closeSoftKeyboard());
    }

    public void inputPassword(String password) {
        Allure.step("Ввод пароля");
        onView(authPage.getPasswordField()).perform(typeText(password), closeSoftKeyboard());
    }

    public void clickBtnEnter() {
        Allure.step("Нажатие на кнопку войти");
        uiHelper.elementWaiting(authPage.btnEnterId);
        onView(withId(authPage.btnEnterId)).perform(click());
    }

    public void clickBtnLogOut() {
        Allure.step("Нажатие на кнопку выход");
        onView(authPage.getAuthorizationBtn()).perform(click());
        onView(authPage.getLogOutBtn()).perform(click());
    }

    public void checkLogOut() {
        Allure.step("Проверка выхода из аккаунта");
        uiHelper.elementWaiting(authPage.loginFieldId);
        onView(authPage.getTitle()).check(matches(isDisplayed()));
    }

    public void checkLogIn() {
        Allure.step("Проверка входа в аккаунт");
        uiHelper.elementWaiting(authPage.authorizationBtnId);
        onView(withId(authPage.authorizationBtnId)).check(matches(isDisplayed()));
    }

    public void successAuth() {
        Allure.step("Успешная авторизация");
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

