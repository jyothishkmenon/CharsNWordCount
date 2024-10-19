package com.truecaller.assignment.charsnwords.repository

import com.truecaller.assignment.charsnwords.Constants
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class TruecallerRepositoryImplTest {

    @Mock
    private lateinit var mockApiService: TruecallerApiService

    private lateinit var repository: TruecallerRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = TruecallerRepositoryImpl(mockApiService)
    }

    @Test
    fun `getWebsiteContent should return content from API service`() = runBlocking {
        val expectedContent = "Test content"
        `when`(mockApiService.getWebsiteContent()).thenReturn(expectedContent)

        val result = repository.getWebsiteContent()

        assertEquals(expectedContent, result)
    }

    @Test
    fun `getNthCharacter should return correct character`() = runBlocking {
        val testContent = "0123456789ABCDEF"
        val expectedChar = testContent[Constants.CHAR_N_INDEX - 1]

        val result = repository.getNthCharacter(testContent)

        assertEquals(expectedChar, result)
    }

    @Test
    fun `getNthCharacter should return space for short content`() = runBlocking {
        val shortContent = "123"

        val result = repository.getNthCharacter(shortContent)

        assertEquals(' ', result)
    }

    @Test
    fun `getEveryNthCharacter should return correct list of characters`() = runBlocking {
        val testContent = "0123456789ABCDEF"
        val expectedChars = listOf('E')

        val result = repository.getEveryNthCharacter(testContent)

        assertEquals(expectedChars, result)
    }

    @Test
    fun `getEveryNthCharacter should return empty list for short content`() = runBlocking {
        val shortContent = "123"

        val result = repository.getEveryNthCharacter(shortContent)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `getWordCount should return correct word count map`() = runBlocking {
        val testContent = "Hello world hello World HELLO"
        val expectedWordCount = mapOf(
            "hello" to 3,
            "world" to 2
        )

        val result = repository.getWordCount(testContent)

        assertEquals(expectedWordCount, result)
    }

    @Test
    fun `getWordCount should handle empty content`() = runBlocking {
        val emptyContent = ""

        val result = repository.getWordCount(emptyContent)

        assertTrue(result.isEmpty())
    }

    @Test
    fun `getWordCount should handle content with only whitespace`() = runBlocking {
        val whitespaceContent = "   \t\n  "

        val result = repository.getWordCount(whitespaceContent)

        assertTrue(result.isEmpty())
    }
}
