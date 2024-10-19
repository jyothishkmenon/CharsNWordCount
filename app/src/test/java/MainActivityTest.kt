//package com.truecaller.assignment.charsnwords
//
//import androidx.compose.ui.test.*
//import androidx.compose.ui.test.junit4.createAndroidComposeRule
//import dagger.hilt.android.testing.HiltAndroidRule
//import dagger.hilt.android.testing.HiltAndroidTest
//import org.junit.Rule
//import org.junit.Test
//
//@HiltAndroidTest
//class MainActivityTest {
//
//    @get:Rule(order = 0)
//    val hiltRule = HiltAndroidRule(this)
//
//    @get:Rule(order = 1)
//    val composeTestRule = createAndroidComposeRule<MainActivity>()
//
//    @Test
//    fun loadContentButton_clickable_and_updates_ui() {
//        composeTestRule.onNodeWithText("Load Content").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Load Content").performClick()
//
//        // Wait for the content to load (you might need to adjust this based on your actual implementation)
//        composeTestRule.waitUntil(5000) {
//            composeTestRule.onAllNodesWithText("15th Character:").fetchSemanticsNodes().isNotEmpty()
//        }
//
//        composeTestRule.onNodeWithText("15th Character:").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Every 15th Character:").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Word Count:").assertIsDisplayed()
//    }
//}