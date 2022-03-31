package de.senfdax.ufobat.shallowblue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun positionAsString() {
        assertEquals("e4", Position.e4.toString())
    }

    @Test
    fun positionA1ByCoordinates() {
        assertEquals(
            Position.a1,
            Position.fromCoordinates(0,0)
        )
    }

    @Test
    fun positionA2ByCoordinates() {
        assertEquals(
            Position.a2,
            Position.fromCoordinates(0,1)
        )
    }

    @Test
    fun positionE2ByCoordinates() {
        assertEquals(
            Position.e2,
            Position.fromCoordinates(4,1)
        )
    }

    @Test
    fun westOfPosition() {
        assertEquals(
            Position.d4,
            Position.e4.west()
        )
    }
    @Test
    fun southOfPosition() {
        assertEquals(
            Position.e3,
            Position.e4.south()
        )
    }
    @Test
    fun eastOfPosition() {
        assertEquals(
            Position.f4,
            Position.e4.east()
        )
    }

}
