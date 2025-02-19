package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.UIHelper;

public class CreateNewsPage {
    UIHelper uiHelper = new UIHelper();

    public int titlePage = R.id.custom_app_bar_title_text_view;
    public int category = R.id.news_item_category_text_auto_complete_text_view;
    public int titleInput = R.id.news_item_title_text_input_edit_text;
    public int publicationDateInput = R.id.news_item_publish_date_text_input_edit_text;
    public int publicationTimeInput = R.id.news_item_publish_time_text_input_edit_text;
    public int descriptionInput = R.id.news_item_description_text_input_edit_text;
    public int statusSwitch = R.id.switcher;
    public int saveBtn = R.id.save_button;
    public int cancelBtn = R.id.cancel_button;

    public Matcher<View> getTitlePage() {
        uiHelper.elementWaiting(titlePage);
        return withId(titlePage);
    }

    public Matcher<View> getCategory() {
        uiHelper.elementWaiting(category);
        return withId(category);
    }

    public Matcher<View> getTitleInput() {
        uiHelper.elementWaiting(titleInput);
        return withId(titleInput);
    }

    public Matcher<View> getPublicationDateInput() {
        uiHelper.elementWaiting(publicationDateInput);
        return withId(publicationDateInput);
    }

    public Matcher<View> getPublicationTimeInput() {
        uiHelper.elementWaiting(publicationTimeInput);
        return withId(publicationTimeInput);
    }

    public Matcher<View> getDescriptionInput() {
        uiHelper.elementWaiting(descriptionInput);
        return withId(descriptionInput);
    }

    public Matcher<View> getStatusSwitch() {
        uiHelper.elementWaiting(statusSwitch);
        return withId(statusSwitch);
    }

    public Matcher<View> getSaveBtn() {
        uiHelper.elementWaiting(saveBtn);
        return withId(saveBtn);
    }

    public Matcher<View> getCancelBtn() {
        uiHelper.elementWaiting(cancelBtn);
        return withId(cancelBtn);
    }

}
