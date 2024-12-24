package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class LoadingPage {
    public int imageId = R.id.splashscreen_image_view;
    public int textId = R.id.splashscreen_text_view;
    public int progressId = R.id.splash_screen_circular_progress_indicator;

    public Matcher<View> getImage() {
        return withId(imageId);
    }

    public Matcher<View> getText() {
        return withId(textId);
    }

    public Matcher<View> getProgress() {
        return withId(progressId);
    }
}
