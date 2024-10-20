//package com.truecaller.assignment.charsnwords.view
//
//import androidx.compose.ui.test.*
//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class AccordionTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Test
//    fun accordion_initialState_isCollapsed() {
//        composeTestRule.setContent {
//            Accordion(
//                title = "Test Accordion",
//                expanded = false,
//                onToggle = {}
//            ) {
//                Text("Accordion content")
//            }
//        }
//
//        composeTestRule.onNodeWithText("Test Accordion").assertIsDisplayed()
//        composeTestRule.onNodeWithContentDescription("Expand").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Accordion content").assertDoesNotExist()
//    }
//
//    @Test
//    fun accordion_expandedState_showsContent() {
//        composeTestRule.setContent {
//            Accordion(
//                title = "Test Accordion",
//                expanded = true,
//                onToggle = {}
//            ) {
//                Text("Accordion content")
//            }
//        }
//
//        composeTestRule.onNodeWithText("Test Accordion").assertIsDisplayed()
//        composeTestRule.onNodeWithContentDescription("Collapse").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Accordion content").assertIsDisplayed()
//    }
//
//    @Test
//    fun accordion_clickExpand_showsContent() {
//        var expanded by mutableStateOf(false)
//
//        composeTestRule.setContent {
//            Accordion(
//                title = "Test Accordion",
//                expanded = expanded,
//                onToggle = { expanded = !expanded }
//            ) {
//                Text("Accordion content")
//            }
//        }
//
//        composeTestRule.onNodeWithContentDescription("Expand").performClick()
//        composeTestRule.onNodeWithText("Accordion content").assertIsDisplayed()
//    }
//
//    @Test
//    fun accordion_clickCollapse_hidesContent() {
//        var expanded by mutableStateOf(true)
//
//        composeTestRule.setContent {
//            Accordion(
//                title = "Test Accordion",
//                expanded = expanded,
//                onToggle = { expanded = !expanded }
//            ) {
//                Text("Accordion content")
//            }
//        }
//
//        composeTestRule.onNodeWithContentDescription("Collapse").performClick()
//        composeTestRule.onNodeWithText("Accordion content").assertDoesNotExist()
//    }
//}
