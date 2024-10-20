//package com.truecaller.assignment.charsnwords.view
//
//import androidx.compose.ui.test.*
//import androidx.compose.ui.test.junit4.createComposeRule
//import org.junit.Rule
//import org.junit.Test
//
//@RunWith(AndroidJUnit4::class)
//class ResponsiveAccordionContainerTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Test
//    fun testSmallDeviceLayout() {
//        val everyNthChar = listOf('a', 'b', 'c')
//        val wordCount = mapOf("hello" to 2, "world" to 1)
//
//        composeTestRule.setContent {
//            ResponsiveAccordionContainer(
//                isSmallDevice = true,
//                everyNthChar = everyNthChar,
//                wordCount = wordCount
//            )
//        }
//
//        // Verify that both accordions are present
//        composeTestRule.onNodeWithText("Every 15th Character").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Word Count").assertIsDisplayed()
//
//        // Verify that the accordions are stacked vertically
//        composeTestRule.onNodeWithText("Every 15th Character")
//            .assertTopPositionInRootIsEqualTo(0.dp)
//        composeTestRule.onNodeWithText("Word Count")
//            .assertTopPositionInRootIsGreaterThan(0.dp)
//
//        // Verify accordion content
//        composeTestRule.onNodeWithText("a, b, c").assertIsDisplayed()
//        composeTestRule.onNodeWithText("hello").assertIsDisplayed()
//        composeTestRule.onNodeWithText("2").assertIsDisplayed()
//        composeTestRule.onNodeWithText("world").assertIsDisplayed()
//        composeTestRule.onNodeWithText("1").assertIsDisplayed()
//    }
//
//    @Test
//    fun testLargeDeviceLayout() {
//        val everyNthChar = listOf('x', 'y', 'z')
//        val wordCount = mapOf("test" to 3, "compose" to 2)
//
//        composeTestRule.setContent {
//            ResponsiveAccordionContainer(
//                isSmallDevice = false,
//                everyNthChar = everyNthChar,
//                wordCount = wordCount
//            )
//        }
//
//        // Verify that both accordions are present
//        composeTestRule.onNodeWithText("Every 15th Character").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Word Count").assertIsDisplayed()
//
//        // Verify that the accordions are side by side
//        composeTestRule.onNodeWithText("Every 15th Character")
//            .assertLeftPositionInRootIsEqualTo(0.dp)
//        composeTestRule.onNodeWithText("Word Count")
//            .assertLeftPositionInRootIsGreaterThan(0.dp)
//
//        // Verify accordion content
//        composeTestRule.onNodeWithText("x, y, z").assertIsDisplayed()
//        composeTestRule.onNodeWithText("test").assertIsDisplayed()
//        composeTestRule.onNodeWithText("3").assertIsDisplayed()
//        composeTestRule.onNodeWithText("compose").assertIsDisplayed()
//        composeTestRule.onNodeWithText("2").assertIsDisplayed()
//    }
//
//    @Test
//    fun testAccordionExpansionAndCollapse() {
//        val everyNthChar = listOf('a')
//        val wordCount = mapOf("test" to 1)
//
//        composeTestRule.setContent {
//            ResponsiveAccordionContainer(
//                isSmallDevice = true,
//                everyNthChar = everyNthChar,
//                wordCount = wordCount
//            )
//        }
//
//        // Initially, both accordions should be expanded
//        composeTestRule.onNodeWithText("a").assertIsDisplayed()
//        composeTestRule.onNodeWithText("test").assertIsDisplayed()
//
//        // Collapse "Every 15th Character" accordion
//        composeTestRule.onNodeWithText("Every 15th Character").performClick()
//        composeTestRule.onNodeWithText("a").assertDoesNotExist()
//
//        // Expand "Every 15th Character" accordion
//        composeTestRule.onNodeWithText("Every 15th Character").performClick()
//        composeTestRule.onNodeWithText("a").assertIsDisplayed()
//
//        // Collapse "Word Count" accordion
//        composeTestRule.onNodeWithText("Word Count").performClick()
//        composeTestRule.onNodeWithText("test").assertDoesNotExist()
//
//        // Expand "Word Count" accordion
//        composeTestRule.onNodeWithText("Word Count").performClick()
//        composeTestRule.onNodeWithText("test").assertIsDisplayed()
//    }
//}