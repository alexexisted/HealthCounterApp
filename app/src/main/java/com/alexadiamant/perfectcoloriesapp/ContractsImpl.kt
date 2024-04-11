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
}