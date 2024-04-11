package com.alexadiamant.perfectcoloriesapp

interface CollectInfoContract {
    fun getGender(rbMan: Boolean): String

    fun getLevelOfActivity(data: String): Float

    fun ageValidator(age: String): Boolean

    fun weightValidator(weight: String): Boolean

    fun heightValidator(height: String): Boolean
}