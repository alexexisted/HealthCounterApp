package com.alexadiamant.perfectcoloriesapp

import org.junit.Assert.assertEquals
import org.junit.Test


class ContractsImplTest {
    private val contract: ContractsImpl = ContractsImpl()

    @Test
    fun `get gender`(){
        assertEquals(contract.getGender(true), "Man")
        assertEquals(contract.getGender(false), "Woman")
    }

    @Test
    fun `get level of activity`(){
        assertEquals(contract.getLevelOfActivity("I am not doing sport"), 1.2F)
        assertEquals(contract.getLevelOfActivity("1 – 3 training a week"), 1.375F)
        assertEquals(contract.getLevelOfActivity("3 – 5 training a week"), 1.55F)
        assertEquals(contract.getLevelOfActivity("More than your can imagine"), 1.8F)
    }

}