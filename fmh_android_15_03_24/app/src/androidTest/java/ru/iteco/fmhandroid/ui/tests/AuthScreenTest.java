package ru.iteco.fmhandroid.ui.tests;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Issue;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.LoadingSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования экрана Авторизация")
public class AuthScreenTest {
    DataGenerator dataGenerator = new DataGenerator();
    LoadingSteps loadingSteps = new LoadingSteps();
    AuthSteps authSteps = new AuthSteps();
    private View decorView;


    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));

    @Before
    public void setup() {
        loadingSteps.checkLoadingScreen();
        try {
            authSteps.checkLoadingAuthPage();
        } catch (Exception e) {
            authSteps.checkLogIn();
            authSteps.clickBtnLogOut();
        }
    }

    @Test
    @DisplayName("Успешная авторизация в приложении")
    public void successfulAuthorizationTest() {
        authSteps.successAuth();
        authSteps.checkLogIn();
        authSteps.clickBtnLogOut();
    }

    @Test
    @DisplayName("Успешная авторизация с вводом данных начинающихся и заканчивающихся пробелами")
    public void successfulAuthorizationWithSpacesTest() {
        authSteps.inputLogin(dataGenerator.loginWithSpaces);
        authSteps.inputPassword(dataGenerator.passwordWithSpaces);
        authSteps.clickBtnEnter();
        authSteps.checkLogIn();
        authSteps.clickBtnLogOut();
    }

    @Test
    @DisplayName("Нельзя авторизоваться в приложении с пустым полем логин и с корректным паролем")
    public void failedAuthorizationWithEmptyLoginTest() {
        authSteps.inputLogin(dataGenerator.emptyLogin);
        authSteps.inputPassword(dataGenerator.password);
        authSteps.clickBtnEnter();
        authSteps.checkAuthError(dataGenerator.emptyLoginOrPasswordException, decorView);
    }

    @Test
    @DisplayName("Нельзя авторизоваться в приложении с пустым полем пароль и с корректным логином")
    public void failedAuthorizationWithEmptyPasswordTest() {
        authSteps.inputLogin(dataGenerator.login);
        authSteps.inputPassword(dataGenerator.emptyPassword);
        authSteps.clickBtnEnter();
        authSteps.checkAuthError(dataGenerator.emptyLoginOrPasswordException, decorView);
    }

    @Test
    @Issue("https://github.com/Zhmaeva/Diplom/issues/3")
    @DisplayName("Нельзя авторизоваться в приложении с корректным логином и паролем зарегистрированного пользователя, написанном в разном регистре")
    public void failedAuthorizationWithDifferentLetterTest() {
        authSteps.inputLogin(dataGenerator.differentRegistersLogin);
        authSteps.inputPassword(dataGenerator.differentRegistersPassword);
        authSteps.clickBtnEnter();
        authSteps.checkAuthError(dataGenerator.wrongLoginOrPasswordException, decorView);
        //authSteps.checkAuthError(dataGenerator.tryAgainLaterException, decorView);
    }

    @Test
    @Issue("https://github.com/Zhmaeva/Diplom/issues/1")
    @DisplayName("Нельзя авторизоваться в приложении с незарегистрированным логином и корректным паролем зарегистрированного пользователя")
    public void failedAuthorizationWithWrongLoginTest() {
        authSteps.inputLogin(dataGenerator.wrongLogin);
        authSteps.inputPassword(dataGenerator.password);
        authSteps.clickBtnEnter();
        authSteps.checkAuthError(dataGenerator.wrongLoginOrPasswordException, decorView);
        //authSteps.checkAuthError(dataGenerator.tryAgainLaterException, decorView);
    }

    @Test
    @Issue("https://github.com/Zhmaeva/Diplom/issues/2")
    @DisplayName("Нельзя авторизоваться в приложении с корректным логином зарегистрированного пользователя и паролем незарегистрированного пользователя")
    public void failedAuthorizationWithWrongPasswordTest() {
        authSteps.inputLogin(dataGenerator.login);
        authSteps.inputPassword(dataGenerator.wrongPassword);
        authSteps.clickBtnEnter();
        authSteps.checkAuthError(dataGenerator.wrongLoginOrPasswordException, decorView);
        //authSteps.checkAuthError(dataGenerator.tryAgainLaterException, decorView);
    }

    @Test
    @Issue("https://github.com/Zhmaeva/Diplom/issues/4")
    @DisplayName("Нельзя авторизоваться в приложении с логином состоящим из 1 символа и корректным паролем зарегистрированного пользователя")
    public void failedAuthorizationWithOneCharacterLoginTest() {
        authSteps.inputLogin(dataGenerator.oneCharacterLogin);
        authSteps.inputPassword(dataGenerator.password);
        authSteps.clickBtnEnter();
        authSteps.checkAuthError(dataGenerator.wrongLoginOrPasswordException, decorView);
        //authSteps.checkAuthError(dataGenerator.tryAgainLaterException, decorView);
    }

    @Test
    @Issue("https://github.com/Zhmaeva/Diplom/issues/5")
    @DisplayName("Нельзя авторизоваться в приложении c корректным логином зарегистрированного пользователя и паролем состоящим из 1 символа")
    public void failedAuthorizationWithOneCharacterPasswordTest() {
        authSteps.inputLogin(dataGenerator.login);
        authSteps.inputPassword(dataGenerator.oneCharacterPassword);
        authSteps.clickBtnEnter();
        authSteps.checkAuthError(dataGenerator.wrongLoginOrPasswordException, decorView);
        //authSteps.checkAuthError(dataGenerator.tryAgainLaterException, decorView);
    }

}