package com.yossisegev.movienight;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TC01_Popular {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    public static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void popularTest_Java() {
        Random random = new Random();
        ViewInteraction recycleView;

        try {
            Thread.sleep(2500);
            int num = 2;
            for (int i = 0; i < num; i++) {

                recycleView = onView(allOf(withId(R.id.popular_movies_recyclerview)));
                recycleView.perform(actionOnItemAtPosition(random.nextInt(19), click()));
                Thread.sleep(1000);

                recycleView = onView(allOf(withId(R.id.details_videos),
                        childAtPosition(withId(R.id.details_video_section), 2)));
                recycleView.perform(actionOnItemAtPosition(0, click()));
                Thread.sleep(3000);

                UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
                mDevice.pressRecentApps();
                mDevice.pressRecentApps();

                recycleView = onView(allOf(withId(R.id.details_favorite_fab), isDisplayed()));
                recycleView.perform(click());

                pressBack();
                Thread.sleep(1000);
            }

            recycleView = onView(allOf(withId(R.id.action_favorites),
                    withContentDescription("My Favorites"), isDisplayed()));
            recycleView.perform(click());

            for (int k = 0; k < num; k++) {
                recycleView = onView(allOf(withId(R.id.favorite_movies_recyclerview)));
                recycleView.perform(actionOnItemAtPosition(0, click()));

                Thread.sleep(1000);

                recycleView = onView(allOf(withId(R.id.details_favorite_fab), isDisplayed()));
                recycleView.perform(click());

                pressBack();

            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
