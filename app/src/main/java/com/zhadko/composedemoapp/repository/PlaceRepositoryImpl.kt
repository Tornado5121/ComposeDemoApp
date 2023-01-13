package com.zhadko.composedemoapp.repository

import android.content.Context
import com.google.gson.Gson
import com.zhadko.composedemoapp.models.Vendors
import com.zhadko.composedemoapp.utils.JSONReader

const val jsonAssetFileName = "vendors.json"

class PlaceRepositoryImpl(
    private val jsonReader: JSONReader,
    private val context: Context,
) : PlaceRepository {

    private val gson = Gson()

    override fun getAllPlaces(): Vendors {
        val placeJson = jsonReader.getJsonDataFromAsset(context, jsonAssetFileName)
        return gson.fromJson(placeJson, Vendors::class.java)
    }
}