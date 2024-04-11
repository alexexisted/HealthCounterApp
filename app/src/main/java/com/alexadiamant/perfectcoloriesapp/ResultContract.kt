package com.alexadiamant.perfectcoloriesapp

interface ResultContract {

    fun count(age: Int, weight: Int, height: Int, gender: String, activity: Double): Int

    fun toGainWeight(normAmount: Int): Int

    fun toLoseWeight(normAmount: Int): Int
}