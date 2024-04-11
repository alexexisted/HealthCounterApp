package com.alexadiamant.perfectcoloriesapp

class ContractsImpl: CollectInfoContract, ResultContract {
    override fun getGender(rbMan: Boolean): String {
        return if (rbMan) {
            "Man"
        } else {
            "Woman"
        }
    }

    override fun getLevelOfActivity(data: String): Float {
        var activityLevel: Float = 0.0F
        when (data) {
            "I am not doing sport" -> {activityLevel = 1.2F}
            "1 – 3 training a week" -> {activityLevel = 1.375F}
            "3 – 5 training a week" -> {activityLevel = 1.55F}
            "More than your can imagine" -> {activityLevel = 1.8F}
        }
        return activityLevel
    }

    //method to calculate calories using args as input data
    override fun count(age: Int, weight: Int, height: Int, gender: String, activity: Double): Int {
        val result = (447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age))

        //check gender of person for better quality of calculations
        when (gender){
            "Woman" -> {val result = (((9.99 * weight) + (6.25 * height) + (4.92 * age)) - 161) * activity}
            "Man" -> {val result = (((9.99 * weight) + (6.25 * height) + (4.92 * age)) + 5) * activity}
        }
        return result.toInt()
    }

    //calculate amount to gain
    override fun toGainWeight(normAmount: Int): Int {
        val toGain = normAmount + (normAmount * 0.3).toInt()
        return toGain
    }

    //calculate amount to lose
    override fun toLoseWeight(normAmount: Int): Int {
        val toLose = normAmount - (normAmount * 0.15).toInt()
        return toLose
    }

    //check if age valid
    override fun ageValidator(age: String): Boolean {
        val minAge = 10
        val maxAge = 110
        if (age.toInt() in (minAge .. maxAge)){
            return true
        }
        else {
            return false
        }
    }

    //check if weight valid
    override fun weightValidator(weight: String): Boolean {
        val minWeight = 30
        val maxWeight = 250

        if (weight.toInt() in (minWeight  ..  maxWeight)) {return true}
        else {return false}
    }

    //check if height valid
    override fun heightValidator(height: String): Boolean {
        val minHeight = 100
        val maxHeight = 250

        if (height.toInt() in (minHeight .. maxHeight)) {return true}
        else {return false}
    }

}