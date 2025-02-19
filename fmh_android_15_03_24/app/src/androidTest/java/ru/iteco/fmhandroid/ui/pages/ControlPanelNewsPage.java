package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.UIHelper;

public class ControlPanelNewsPage {
    UIHelper uiHelper = new UIHelper();

    public int sortBtn = R.id.sort_news_material_button;
    public int filterBtn = R.id.filter_news_material_button;
    public int addNewsBtn = R.id.add_news_image_view;

    public int newsListView = R.id.news_list_recycler_view;
    public int titleNews = R.id.news_item_title_text_view;
    public int publicationTextView = R.id.news_item_publication_text_view;
    public int publicationDate = R.id.news_item_publication_date_text_view;
    public int creationTextView = R.id.news_item_creation_text_view;
    public int creationDate = R.id.news_item_create_date_text_view;
    public int authorTextView = R.id.news_item_author_text_view;
    public int authorName = R.id.news_item_author_name_text_view;
    public int status = R.id.news_item_published_text_view;

    public int deleteNewsBtn = R.id.delete_news_item_image_view;
    public int editNewsBtn = R.id.edit_news_item_image_view;
    public int viewNewsBtn = R.id.view_news_item_image_view;
    public int descriptionNews = R.id.news_item_description_text_view;

    public Matcher<View> getTitle() {
        return withText("Control panel");
    }

    public Matcher<View> getSortNewsBtn() {
        uiHelper.elementWaiting(sortBtn);
        return withId(sortBtn);
    }

    public Matcher<View> getFilterNewsBtn() {
        uiHelper.elementWaiting(filterBtn);
        return withId(filterBtn);
    }

    public Matcher<View> getAddNewsBtn() {
        uiHelper.elementWaiting(addNewsBtn);
        return withId(addNewsBtn);
    }

    public Matcher<View> deleteNewsWithTitle(String title) {
        uiHelper.elementWaiting(deleteNewsBtn);
        return allOf(withId(deleteNewsBtn),
                withParent(withParent(allOf(
                        withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title)))))));
    }

    public Matcher<View> editNewsWithTitle(String title) {
        uiHelper.elementWaiting(editNewsBtn);
        return allOf(withId(editNewsBtn),
                withParent(withParent(allOf(
                        withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title)))))));
    }

    public Matcher<View> getViewNewsBtn(String title) {
        uiHelper.elementWaiting(viewNewsBtn);
        return allOf(withId(viewNewsBtn),
                withParent(withParent(allOf(
                        withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title)))))));
    }

    public Matcher<View> getDescriptionNews(String description) {
        uiHelper.elementWaiting(descriptionNews);
        return allOf(withId(descriptionNews),
                withParent(withParent(allOf(
                        withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(description)))))));
    }

    public Matcher<View> getNewsStatus(String text) {
        uiHelper.elementWaiting(status);
        return allOf(withId(status),
                withParent(withParent(allOf(
                        withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(text)))))));
    }

}
