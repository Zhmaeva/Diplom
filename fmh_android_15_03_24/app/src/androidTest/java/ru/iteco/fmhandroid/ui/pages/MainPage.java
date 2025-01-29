package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.UIHelper;

public class MainPage {
    UIHelper uiHelper = new UIHelper();

    // AppBar
    public int mainMenu = R.id.main_menu_image_button;
    public int mainTitle = android.R.id.title;

    public int trademarkImageView = R.id.trademark_image_view;
    public int ourMissionImageButton = R.id.our_mission_image_button;

    public int authorizationImageButton = R.id.authorization_image_button;

    // All News
    public int allNewsTextView = R.id.all_news_text_view;
    // Last News
    public int newsListMainContainer = R.id.container_list_news_include_on_fragment_main;
    public int newsItemTitleTextView = R.id.news_item_title_text_view;
    public int newsItemDateTextView = R.id.news_item_date_text_view;
    public int newsDescriptionTextView = R.id.news_item_description_text_view;
    public int expandDescriptionBtn = R.id.view_news_item_image_view;

    public Matcher<View> getMainMenuBtn() {
        uiHelper.elementWaiting(mainMenu);
        return allOf(
                withId(mainMenu),
                withContentDescription("Main menu"));
    }

    public Matcher<View> getMenuItemNews() {
        return allOf(
                withId(mainTitle),
                withText("News"));
    }

    public Matcher<View> getTrademarkImageView() {
        uiHelper.elementWaiting(trademarkImageView);
        return withId(trademarkImageView);
    }

    public Matcher<View> getOurMissionImageButton() {
        uiHelper.elementWaiting(ourMissionImageButton);
        return withId(ourMissionImageButton);
    }

    public Matcher<View> getAuthorizationImageButton() {
        uiHelper.elementWaiting(authorizationImageButton);
        return allOf(
                withId(authorizationImageButton),
                withContentDescription("Authorization"));
    }

    public Matcher<View> getAllNewsLink() {
        uiHelper.elementWaiting(allNewsTextView);
        return allOf(
                withId(allNewsTextView),
                withText("All news"));
    }

    public Matcher<View> getNewsTitleTextView() {
        uiHelper.elementWaiting(newsItemTitleTextView);
        return withId(newsItemTitleTextView);
    }

    public Matcher<View> getNewsDateTextView() {
        uiHelper.elementWaiting(newsItemDateTextView);
        return withId(newsItemDateTextView);
    }

    public Matcher<View> getExpandDescriptionBtn() {
        uiHelper.elementWaiting(expandDescriptionBtn);
        return withId(expandDescriptionBtn);
    }

    public Matcher<View> getNewsDescriptionTextView() {
        uiHelper.elementWaiting(newsDescriptionTextView);
        return withId(newsDescriptionTextView);
    }

    public Matcher<View> getNewsContainer() {
        uiHelper.elementWaiting(newsListMainContainer);
        return withId(newsListMainContainer);
    }






}
