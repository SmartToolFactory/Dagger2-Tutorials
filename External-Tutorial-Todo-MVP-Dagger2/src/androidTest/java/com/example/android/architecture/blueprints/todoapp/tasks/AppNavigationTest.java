/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp.tasks;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.NoActivityResumedException;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.util.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.android.architecture.blueprints.todoapp.TestUtils.getToolbarNavigationContentDescription;
import static com.example.android.architecture.blueprints.todoapp.custom.action.NavigationViewActions.navigateTo;
import static junit.framework.Assert.fail;

/**
 * Tests for the {@link DrawerLayout} layout component in {@link TasksActivity} which manages
 * navigation within the app.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AppNavigationTest {

    /**
     * {@link ActivityTestRule} is a JUnit {@link Rule @Rule} to launch your activity under test.
     *
     * <p>
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */
    @Rule
    public ActivityTestRule<TasksActivity> mActivityTestRule =
            new ActivityTestRule<>(TasksActivity.class);
    /**
     * Prepare your test fixture for this test. In this case we register an IdlingResources with
     * Espresso. IdlingResource resource is a great way to tell Espresso when your app is in an
     * idle state. This helps Espresso to synchronize your test actions, which makes tests
     * significantly more reliable.
     */
    @Before
    public void registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
    }

    /**
     * Unregister your Idling Resource so it can be garbage collected and does not leak any memory.
     */
    @After
    public void unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource());
    }

    @Test
    public void clickOnStatisticsNavigationItem_ShowsStatisticsScreen() {
        openStatisticsScreen();

        // Check that statistics Activity was opened.
        onView(withId(R.id.statistics)).check(matches(isDisplayed()));
    }

    @Test
    public void clickOnListNavigationItem_ShowsListScreen() {
        openStatisticsScreen();

        openTasksScreen();

        // Check that Tasks Activity was opened.
        onView(withId(R.id.tasksContainer)).check(matches(isDisplayed()));
    }

    @Test
    public void clickOnAndroidHomeIcon_OpensNavigation() {
        // Check that left drawer is closed at startup
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))); // Left Drawer should be closed.

        // Open Drawer
        onView(withContentDescription(getToolbarNavigationContentDescription(
                mActivityTestRule.getActivity(), R.id.toolbar))).perform(click());

        // Check if drawer is open
        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen(Gravity.LEFT))); // Left drawer is open open.
    }

    @Test
    public void Statistics_backNavigatesToTasks() {
        openStatisticsScreen();

        // Press back to go back to the tasks list
        pressBack();

        // Check that Tasks Activity was restored.
        onView(withId(R.id.tasksContainer)).check(matches(isDisplayed()));
    }

    @Test
    public void backFromTasksScreen_ExitsApp() {
        // From the tasks screen, press back should exit the app.
        assertPressingBackExitsApp();
    }

    @Test
    public void backFromTasksScreenAfterStats_ExitsApp() {
        // This test checks that TasksActivity is a parent of StatisticsActivity

        // Open the stats screen
        openStatisticsScreen();

        // Open the tasks screen to restore the task
        openTasksScreen();

        // Pressing back should exit app
        assertPressingBackExitsApp();
    }

    private void assertPressingBackExitsApp() {
        try {
            pressBack();
            fail("Should kill the app and throw an exception");
        } catch (NoActivityResumedException e) {
            // Test OK
        }
    }

    private void openTasksScreen() {
        // Open Drawer to click on navigation item.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(open()); // Open Drawer

        // Start tasks list screen.
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.list_navigation_menu_item));
    }

    private void openStatisticsScreen() {
        // Open Drawer to click on navigation item.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(open()); // Open Drawer

        // Start statistics screen.
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.statistics_navigation_menu_item));
    }
}
