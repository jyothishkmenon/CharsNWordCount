//package com.truecaller.assignment.charsnwords.view
//
//import androidx.compose.ui.test.*
//import androidx.compose.ui.test.junit4.createAndroidComposeRule
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.truecaller.assignment.charsnwords.viewmodel.MainViewModel
//import dagger.hilt.android.testing.HiltAndroidRule
//import dagger.hilt.android.testing.HiltAndroidTest
//import kotlinx.coroutines.flow.MutableStateFlow
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import javax.inject.Inject
//
//@HiltAndroidTest
//@RunWith(AndroidJUnit4::class)
//class MainActivityTest {
//
//    @get:Rule(order = 0)
//    val hiltRule = HiltAndroidRule(this)
//
//    @get:Rule(order = 1)
//    val composeTestRule = createAndroidComposeRule<MainActivity>()
//
//    @Inject
//    lateinit var viewModel: MainViewModel
//
//    @Before
//    fun setUp() {
//        hiltRule.inject()
//    }
//
//    @Test
//    fun testInitialState() {
//        composeTestRule.onNodeWithText("Load Content").assertIsDisplayed()
//        composeTestRule.onNodeWithText("15th Character:").assertDoesNotExist()
//        composeTestRule.onNodeWithText("Every 15th Character").assertDoesNotExist()
//        composeTestRule.onNodeWithText("Word Count").assertDoesNotExist()
//    }
//
//    @Test
//    fun testLoadingState() {
//        viewModel.isLoading.value = true
//        composeTestRule.onNodeWithTag("CircularProgressIndicator").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Load Content").assertIsDisplayed()
//    }
//
//    @Test
//    fun testLoadedState() {
//        viewModel.apply {
//            isLoading.value = false
//            nthCharacter.value = 'A'
//            everyNthCharacter.value = listOf('A', 'B', 'C')
//            wordCount.value = mapOf("test" to 1, "word" to 2)
//        }
//
//        composeTestRule.onNodeWithText("15th Character:").assertIsDisplayed()
//        composeTestRule.onNodeWithText("A").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Every 15th Character").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Word Count").assertIsDisplayed()
//    }
//
//    @Test
//    fun testLoadContentButton() {
//        composeTestRule.onNodeWithText("Load Content").performClick()
//        // Verify that loading is triggered (you might need to add a small delay or use IdlingResource)
//        composeTestRule.onNodeWithTag("CircularProgressIndicator").assertIsDisplayed()
//    }
//
//    @Test
//    fun testAccordionExpansion() {
//        viewModel.apply {
//            isLoading.value = false
//            nthCharacter.value = 'A'
//            everyNthCharacter.value = listOf('A', 'B', 'C')
//            wordCount.value = mapOf("test" to 1)
//        }
//
//        // Initially, accordions should be expanded
//        composeTestRule.onNodeWithText("A, B, C").assertIsDisplayed()
//        composeTestRule.onNodeWithText("test").assertIsDisplayed()
//
//        // Collapse "Every 15th Character" accordion
//        composeTestRule.onNodeWithText("Every 15th Character").performClick()
//        composeTestRule.onNodeWithText("A, B, C").assertDoesNotExist()
//
//        // Collapse "Word Count" accordion
//        composeTestRule.onNodeWithText("Word Count").performClick()
//        composeTestRule.onNodeWithText("test").assertDoesNotExist()
//
//        // Expand accordions again
//        composeTestRule.onNodeWithText("Every 15th Character").performClick()
//        composeTestRule.onNodeWithText("A, B, C").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Word Count").performClick()
//        composeTestRule.onNodeWithText("test").assertIsDisplayed()
//    }
//}