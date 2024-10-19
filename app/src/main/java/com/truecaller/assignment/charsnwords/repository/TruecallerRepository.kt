package com.truecaller.assignment.charsnwords.repository

import com.truecaller.assignment.charsnwords.Constants
import java.util.Locale
import javax.inject.Inject

interface TruecallerRepository {
    suspend fun getWebsiteContent(): String
    suspend fun getNthCharacter(content: String): Char
    suspend fun getEveryNthCharacter(content: String): List<Char>
    suspend fun getWordCount(content: String): Map<String, Int>
}

class TruecallerRepositoryImpl @Inject constructor(
    private val apiService: TruecallerApiService
) : TruecallerRepository {

    override suspend fun getWebsiteContent(): String {
        return apiService.getWebsiteContent()
    }

    override suspend fun getNthCharacter(content: String): Char {
        return content.getOrElse(Constants.CHAR_N_INDEX - 1) { ' ' }
    }

    override suspend fun getEveryNthCharacter(content: String): List<Char> {
        return content.filterIndexed { index, _ -> (index + 1) % Constants.CHAR_SCAN_INDEX == 0 }
            .toList()
    }

    override suspend fun getWordCount(content: String): Map<String, Int> {
        return content.split(Regex("\\s+"))
            .filter { it.isNotEmpty() }
            .groupBy { it.lowercase(Locale.getDefault()) }
            .mapValues { it.value.size }
    }
}
