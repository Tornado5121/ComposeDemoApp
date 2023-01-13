package com.zhadko.composedemoapp.repository

import com.zhadko.composedemoapp.models.Vendors

interface PlaceRepository {
    fun getAllPlaces(): Vendors
}