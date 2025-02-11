package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import android.view.View;
import org.hamcrest.Matcher;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.UIHelper;

public class NewsMainPage {
    UIHelper uiHelper = new UIHelper();

    public int sortNews = R.id.sort_news_material_button;
    public int filterNews = R.id.filter_news_material_button;
    public int controlPanel = R.id.edit_news_material_button;

    public Matcher<View> getSortNewsBtn() {
        uiHelper.elementWaiting(sortNews);
        return withId(sortNews);
    }

    public Matcher<View> getFilterNewsBtn() {
        uiHelper.elementWaiting(filterNews);
        return withId(filterNews);
    }

    public Matcher<View> getControlPanelBtn() {
        uiHelper.elementWaiting(controlPanel);
        return withId(controlPanel);
    }
}
