package com.truecaller.assignment.charsnwords.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.truecaller.assignment.charsnwords.repository.TruecallerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(testDispatcher)

    @Mock
    private lateinit var repository: TruecallerRepository

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = MainViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun `loadContent sets isLoading to true then false`() = testScope.runBlockingTest {
        // Given
        val content = "Test content"
        `when`(repository.getWebsiteContent()).thenReturn(content)

        val loadingValues = mutableListOf<Boolean>()
        val loadingObserver = Observer<Boolean> { loadingValues.add(it) }

        viewModel.isLoading.observeForever(loadingObserver)

        // When
        viewModel.loadContent()

        // Then
        advanceUntilIdle()

        viewModel.isLoading.removeObserver(loadingObserver)

        assert(loadingValues.size >= 2) { "Expected at least 2 loading state changes, but got ${loadingValues.size}" }
        assert(loadingValues[0]) { "Expected first loading state to be true, but was ${loadingValues[0]}" }
        assert(!loadingValues.last()) { "Expected last loading state to be false, but was ${loadingValues.last()}" }
    }

    @Test
    fun `loadContent updates LiveData with correct values`() = testScope.runBlockingTest {
        // Given
        val content = "Test content"
        val nthChar = 'T'
        val everyNthChar = listOf('T', 's', 'c')
        val wordCount = mapOf("test" to 1, "content" to 1)

        `when`(repository.getWebsiteContent()).thenReturn(content)
        `when`(repository.getNthCharacter(content)).thenReturn(nthChar)
        `when`(repository.getEveryNthCharacter(content)).thenReturn(everyNthChar)
        `when`(repository.getWordCount(content)).thenReturn(wordCount)

        // When
        viewModel.loadContent()
        advanceUntilIdle()

        // Then
        assert(viewModel.nthCharacter.value == nthChar)
        assert(viewModel.everyNthCharacter.value == everyNthChar)
        assert(viewModel.wordCount.value == wordCount)
    }

    @Test
    fun `loadContent handles exceptions`() = testScope.runBlockingTest {
        // Given
        `when`(repository.getWebsiteContent()).thenThrow(RuntimeException("Network error"))

        // When
        viewModel.loadContent()
        advanceUntilIdle()

        // Then
        assert(viewModel.isLoading.value == false)
        // Verify that other LiveData values haven't changed
        assert(viewModel.nthCharacter.value == null)
        assert(viewModel.everyNthCharacter.value == null)
        assert(viewModel.wordCount.value == null)
    }

    @Test
    fun `loadContent calls repository methods`() = testScope.runBlockingTest {
        // Given
        val content = "Test content"
        `when`(repository.getWebsiteContent()).thenReturn(content)

        // When
        viewModel.loadContent()
        advanceUntilIdle()

        // Then
        verify(repository).getWebsiteContent()
        verify(repository).getNthCharacter(content)
        verify(repository).getEveryNthCharacter(content)
        verify(repository).getWordCount(content)
    }
}
