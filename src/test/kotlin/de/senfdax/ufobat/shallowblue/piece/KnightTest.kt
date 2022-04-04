package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.Move
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KnightTest {

    @Test
    fun cornerKnightMoves() {
        val knight = Knight(Position.a1, Piece.WHITE)
        val moves = knight.pseudoLegalMoves()

        assertEquals(
            setOf(
                Move(Position.a1, Position.b3),
                Move(Position.a1, Position.c2)
            ),
            moves.toSet()
        )
    }

    @Test
    fun sideKnightMoves() {
        val knight = Knight(Position.a4, Piece.WHITE)
        val moves = knight.pseudoLegalMoves()

        assertEquals(
            setOf(
                Move(Position.a4, Position.b2),
                Move(Position.a4, Position.b6),
                Move(Position.a4, Position.c3),
                Move(Position.a4, Position.c5),
            ),
            moves.toSet()
        )
    }

    @Test
    fun middleKnightMoves() {
        val knight = Knight(Position.e4, Piece.WHITE)
        val moves = knight.pseudoLegalMoves()

        assertEquals(
            setOf(
                // west
                Move(Position.e4, Position.c3),
                Move(Position.e4, Position.c5),
                // north
                Move(Position.e4, Position.d6),
                Move(Position.e4, Position.f6),
                // east
                Move(Position.e4, Position.g3),
                Move(Position.e4, Position.g5),
                //
                Move(Position.e4, Position.d2),
                Move(Position.e4, Position.f2),
            ),
            moves.toSet()
        )
    }
}
