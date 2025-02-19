package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataGenerator;
import ru.iteco.fmhandroid.ui.data.UIHelper;

public class FilterNewsPage {
    UIHelper uiHelper = new UIHelper();
    DataGenerator dataGenerator = new DataGenerator();

    public int title = R.id.filter_news_title_text_view;
    public int category = R.id.news_item_category_text_auto_complete_text_view;
    public int dateStart = R.id.news_item_publish_date_start_text_input_edit_text;
    public int dateEnd = R.id.news_item_publish_date_end_text_input_edit_text;
    public int activeCheckBox = R.id.filter_news_active_material_check_box;
    public int notActiveCheckBox = R.id.filter_news_inactive_material_check_box;
    public int filterBtn = R.id.filter_button;
    public int cancelBtn = R.id.cancel_button;

    public Matcher<View> getTitle() {
        uiHelper.elementWaiting(title);
        return allOf(
                withId(title),
                withText(dataGenerator.filterNews));
    }

    public Matcher<View> getCategory() {
        uiHelper.elementWaiting(category);
        return allOf(
                withId(category),
                withText(dataGenerator.category));
    }

    public Matcher<View> getDateStart() {
        uiHelper.elementWaiting(dateStart);
        return withId(dateStart);
    }

    public Matcher<View> getDateEnd() {
        uiHelper.elementWaiting(dateEnd);
        return withId(dateEnd);
    }

    public Matcher<View> getActiveCheckBox() {
        uiHelper.elementWaiting(activeCheckBox);
        return withId(activeCheckBox);
    }

    public Matcher<View> getNotActiveCheckBox() {
        uiHelper.elementWaiting(notActiveCheckBox);
        return withId(notActiveCheckBox);
    }

    public Matcher<View> getFilterBtn() {
        uiHelper.elementWaiting(filterBtn);
        return allOf(
                withId(filterBtn),
                withText(dataGenerator.filter));
    }

    public Matcher<View> getCancelBtn() {
        uiHelper.elementWaiting(cancelBtn);
        return allOf(
                withId(cancelBtn),
                withText(dataGenerator.cancel));
    }

}
