package ru.iteco.fmhandroid.ui.data;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    public String truePrivacyPolicyLink = "https://vhospice.org/privacy-policy/";
    public String trueTermsOfUseLink = "https://vhospice.org/terms-of-use";


    // Страница Новости > Фильтр новостей
    public String filter = "FILTER";
    public String cancel = "CANCEL";
    public String filterNews = "Filter news";
    public String category = "Category";


    // Страница Новости > Добавить новость
    public String titlePageAddNews = "Creating";
    public String emptyFieldsMsg = "Fill empty fields";

    public static String generateTitle() {
        Faker faker = new Faker(new Locale("ru"));
        String title;
        title= faker.dune().title();
        return title;
    }

    public static String generateDescription() {
        Faker faker = new Faker(new Locale("ru"));
        String description;
        description = faker.dune().saying();
        return description;
    }

    public static String getCurrentDate() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return dateFormat.format(currentDate);
    }

    public static String getCurrentTime() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return dateFormat.format(currentDate);
    }

    public static String generateDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Faker faker = new Faker(new Locale("ru"));
        String date;
        date = sdf.format(faker.date().birthday());
        return date;
    }

    public static String generateFutureDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Faker faker = new Faker(new Locale("ru"));
        String date;
        date = sdf.format(faker.date().future(360, TimeUnit.DAYS));
        return date;
    }

    public static String generatePastDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Faker faker = new Faker(new Locale("ru"));
        String date;
        date = sdf.format(faker.date().past(150, TimeUnit.DAYS));
        return date;
    }

    public static class RandomCategory {
        static final Random rand = new Random();

        public static String randomCategory() {
            String[] categories = {
                    "Объявление",
                    "День рождения",
                    "Зарплата",
                    "Профсоюз",
                    "Праздник",
                    "Массаж",
                    "Благодарность",
                    "Нужна помощь"
            };
            final String category = categories[rand.nextInt(categories.length)];
            return category;
        }
    }

}


