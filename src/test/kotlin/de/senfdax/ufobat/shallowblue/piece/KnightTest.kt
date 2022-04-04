package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.SimpleMove
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KnightTest {

    @Test
    fun cornerKnightMoves() {
        val knight = Knight(Position.a1)
        val moves = knight.pseudoLegalMoves()

        assertEquals(
            setOf(
                SimpleMove(Position.a1, Position.b3),
                SimpleMove(Position.a1, Position.c2)
            ),
            moves.toSet()
        )
    }

    @Test
    fun sideKnightMoves() {
        val knight = Knight(Position.a4)
        val moves = knight.pseudoLegalMoves()

        assertEquals(
            setOf(
                SimpleMove(Position.a4, Position.b2),
                SimpleMove(Position.a4, Position.b6),
                SimpleMove(Position.a4, Position.c3),
                SimpleMove(Position.a4, Position.c5),
            ),
            moves.toSet()
        )
    }

    @Test
    fun middleKnightMoves() {
        val knight = Knight(Position.e4)
        val moves = knight.pseudoLegalMoves()

        assertEquals(
            setOf(
                // west
                SimpleMove(Position.e4, Position.c3),
                SimpleMove(Position.e4, Position.c5),
                // north
                SimpleMove(Position.e4, Position.d6),
                SimpleMove(Position.e4, Position.f6),
                // east
                SimpleMove(Position.e4, Position.g3),
                SimpleMove(Position.e4, Position.g5),
                //
                SimpleMove(Position.e4, Position.d2),
                SimpleMove(Position.e4, Position.f2),
            ),
            moves.toSet()
        )
    }
}
