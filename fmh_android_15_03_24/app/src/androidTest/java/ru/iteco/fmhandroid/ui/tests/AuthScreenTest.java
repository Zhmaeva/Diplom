package ru.iteco.fmhandroid.ui.tests;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.LoadingSteps;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class AuthScreenTest {
    DataGenerator dataGenerator = new DataGenerator();
    LoadingSteps loadingSteps = new LoadingSteps();
    AuthSteps authSteps = new AuthSteps();


    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setup() {
        loadingSteps.checkLoadingScreen();
        authSteps.checkLoadingAuthPage();
    }

    // успешная авторизация в приложении
    @Test
    public void successfulAuthorizationTest() {
        authSteps.successAuth();
        authSteps.checkLogIn();
        authSteps.clickBtnLogOut();
    }

    // успешная авторизация с вводом данных начинающихся и заканчивающихся пробелами
    @Test
    public void successfulAuthorizationWithSpacesTest() {
        authSteps.inputLogin(dataGenerator.loginWithSpaces);
        authSteps.inputPassword(dataGenerator.passwordWithSpaces);
        authSteps.clickBtnEnter();
        authSteps.checkLogIn();
        authSteps.clickBtnLogOut();
    }

    // Нельзя авторизоваться в приложении с пустым полем логин и с корректным паролем
    @Test
    public void failedAuthorizationWithEmptyLoginTest() {
        authSteps.inputLogin(dataGenerator.emptyLogin);
        authSteps.inputPassword(dataGenerator.password);
        authSteps.clickBtnEnter();
        authSteps.checkErrorAuth(dataGenerator.emptyLoginOrPasswordException);
    }

    // Нельзя авторизоваться в приложении с пустым полем пароль и с корректным логином
    @Test
    public void failedAuthorizationWithEmptyPasswordTest() {
        authSteps.inputLogin(dataGenerator.login);
        authSteps.inputPassword(dataGenerator.emptyPassword);
        authSteps.clickBtnEnter();
        authSteps.checkErrorAuth(dataGenerator.emptyLoginOrPasswordException);
    }

    // Нельзя авторизоваться в приложении с логином незарегистрированного пользователя и
    // корректным паролем зарегистрированного пользователя
    @Test
    public void failedAuthorizationWithWrongLoginTest() {
        authSteps.inputLogin(dataGenerator.wrongLogin);
        authSteps.inputPassword(dataGenerator.password);
        authSteps.clickBtnEnter();
        authSteps.checkErrorAuth(dataGenerator.wrongLoginOrPasswordException);
    }

    // Нельзя авторизоваться в приложении с корректным логином зарегистрированного пользователя и
    // паролем незарегистрированного пользователя
    @Test
    public void failedAuthorizationWithWrongPasswordTest() {
        authSteps.inputLogin(dataGenerator.login);
        authSteps.inputPassword(dataGenerator.wrongPassword);
        authSteps.clickBtnEnter();
        authSteps.checkErrorAuth(dataGenerator.wrongLoginOrPasswordException);
    }

    // Нельзя авторизоваться в приложении с логином состоящим из 1 символа и
    // корректным паролем зарегистрированного пользователя
    @Test
    public void failedAuthorizationWithOneCharacterLoginTest() {
        authSteps.inputLogin(dataGenerator.oneCharacterLogin);
        authSteps.inputPassword(dataGenerator.password);
        authSteps.clickBtnEnter();
        authSteps.checkErrorAuth(dataGenerator.wrongLoginOrPasswordException);
    }

    // Нельзя авторизоваться в приложении с корректным логином зарегистрированного пользователя и
    // паролем из 1 символа
    @Test
    public void failedAuthorizationWithOneCharacterPasswordTest() {
        authSteps.inputLogin(dataGenerator.login);
        authSteps.inputPassword(dataGenerator.oneCharacterPassword);
        authSteps.clickBtnEnter();
        authSteps.checkErrorAuth(dataGenerator.wrongLoginOrPasswordException);
    }

    // Нельзя авторизоваться в приложении с корректным логином и паролем
    // зарегистрированного пользователя, написанном в разном регистре
    @Test
    public void failedAuthorizationWithDifferentLetterTest() {
        authSteps.inputLogin(dataGenerator.differentRegistersLogin);
        authSteps.inputPassword(dataGenerator.differentRegistersPassword);
        authSteps.clickBtnEnter();
        authSteps.checkErrorAuth(dataGenerator.wrongLoginOrPasswordException);
    }

}