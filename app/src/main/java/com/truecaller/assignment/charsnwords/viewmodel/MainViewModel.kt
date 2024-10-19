package com.truecaller.assignment.charsnwords.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.truecaller.assignment.charsnwords.repository.TruecallerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: TruecallerRepository
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _nthCharacter = MutableLiveData<Char>()
    val nthCharacter: LiveData<Char> = _nthCharacter

    private val _everyNthCharacter = MutableLiveData<List<Char>>()
    val everyNthCharacter: LiveData<List<Char>> = _everyNthCharacter

    private val _wordCount = MutableLiveData<Map<String, Int>>()
    val wordCount: LiveData<Map<String, Int>> = _wordCount

    fun loadContent() {
        viewModelScope.launch {
            try {
                _isLoading.postValue(true)
                val content = repository.getWebsiteContent()
                _isLoading.postValue(false)

                launch { _nthCharacter.postValue(repository.getNthCharacter(content)) }
                launch { _everyNthCharacter.postValue(repository.getEveryNthCharacter(content)) }
                launch { _wordCount.postValue(repository.getWordCount(content)) }
            } catch (e: Exception) {
                _isLoading.postValue(false)
            } finally {
                _isLoading.postValue(false)
            }
        }
    }
}
