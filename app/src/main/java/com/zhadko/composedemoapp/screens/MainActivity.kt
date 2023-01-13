package com.zhadko.composedemoapp.screens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.zhadko.composedemoapp.screens.placeListScreen.PlaceItem
import com.zhadko.composedemoapp.screens.placeListScreen.PlaceListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModel<PlaceListViewModel>()

        setContent {
            val getAllPlaces = viewModel.places.collectAsState().value
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(getAllPlaces) { place ->
                    PlaceItem(place = place)
                }
            }
        }
    }
}