package ru.iteco.fmhandroid.ui.data;

import com.github.javafaker.Faker;

public class DataGenerator {

    // Страница авторизации
    public String login = "login2";
    public String password = "password2";
    public String emptyLogin = "";
    public String emptyPassword = "";
    public String loginWithSpaces = " login2 ";
    public String passwordWithSpaces = " password2 ";
    public String wrongLogin = generateLogin();
    public String wrongPassword = generatePassword();
    public String oneCharacterLogin = "l";
    public String oneCharacterPassword = "p";
    public String differentRegistersLogin = "lOGin2";
    public String differentRegistersPassword = "paSSwORd2";

    public String emptyLoginOrPasswordException = "Login and password cannot be empty";
    public String wrongLoginOrPasswordException = "Wrong login or password";
    public String tryAgainLaterException = "Something went wrong. Try again later.";

    public static String generateLogin() {
        Faker faker = new Faker();
        String login;
        login = faker.name().username();
        return login;
    }

    public static String generatePassword() {
        Faker faker = new Faker();
        String password;
        password = faker.internet().password();
        return password;
    }

    // Страница О приложении
    public String privacyPolicyLink = "https://vhospice.org/#/privacy-policy/";
    public String termsOfUseLink = "https://vhospice.org/#/terms-of-use";
    public String version = "1.0.0";



    // Главная страница
//    public static String generateDate(int shift) {
//        String date;
//        date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        return date;
//    }

}
