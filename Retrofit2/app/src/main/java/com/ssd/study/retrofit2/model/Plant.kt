package com.ssd.study.retrofit2.model

data class Plant(
    val plantId: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val waterInterval: Int,
    val imageUrl: String
)
