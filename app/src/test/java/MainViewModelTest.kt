//package com.truecaller.assignment.charsnwords.viewmodel
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import io.mockk.coEvery
//import io.mockk.mockk
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.TestCoroutineDispatcher
//import kotlinx.coroutines.test.resetMain
//import kotlinx.coroutines.test.runBlockingTest
//import kotlinx.coroutines.test.setMain
//import org.junit.After
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import kotlin.test.assertEquals
//
//@ExperimentalCoroutinesApi
//class MainViewModelTest {
//
//    @get:Rule
//    val instantExecutorRule = InstantTaskExecutorRule()
//
//    private val testDispatcher = TestCoroutineDispatcher()
//    private lateinit var viewModel: MainViewModel
//    private lateinit var repository: TruecallerRepository
//
//    @Before
//    fun setup() {
//        Dispatchers.setMain(testDispatcher)
//        repository = mockk()
//        viewModel = MainViewModel(repository)
//    }
//
//    @After
//    fun tearDown() {
//        Dispatchers.resetMain()
//        testDispatcher.cleanupTestCoroutines()
//    }
//
//    @Test
//    fun `loadContent updates uiState correctly`() = runBlockingTest {
//        // Given
//        val testContent = "This is a test content for Truecaller analysis"
//        coEvery { repository.getWebsiteContent() } returns testContent
//        coEvery { repository.getFifteenthCharacter(any()) } returns 't'
//        coEvery { repository.getEveryFifteenthCharacter(any()) } returns listOf('t', 'r')
//        coEvery { repository.getWordCount(any()) } returns mapOf("this" to 1, "is" to 1, "a" to 1)
//
//        // When
//        viewModel.loadContent()
//
//        // Then
//        assertEquals('t', viewModel.uiState.value.fifteenthCharacter)
//        assertEquals(listOf('t', 'r'), viewModel.uiState.value.everyFifteenthCharacter)
//        assertEquals(mapOf("this" to 1, "is" to 1, "a" to 1), viewModel.uiState.value.wordCount)
//    }
//}