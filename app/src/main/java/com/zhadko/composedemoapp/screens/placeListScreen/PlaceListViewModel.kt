package com.zhadko.composedemoapp.screens.placeListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhadko.composedemoapp.models.Place
import com.zhadko.composedemoapp.repository.PlaceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlaceListViewModel(
    private val placeRepository: PlaceRepository
) : ViewModel() {

    private val _places = MutableStateFlow<List<Place>>(emptyList())
    val places = _places.asStateFlow()

    init {
        getPlaces()
    }

    private fun getPlaces() {
        viewModelScope.launch {
            _places.update {
                placeRepository.getAllPlaces().vendors
            }
        }
    }
}