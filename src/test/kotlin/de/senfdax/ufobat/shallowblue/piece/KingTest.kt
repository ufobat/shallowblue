package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.Move
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KingTest {

    @Test
    fun moveKingInTheCorner() {
        val king = King(Position.a1, Piece.WHITE)
        val moves = king.pseudoLegalMoves()
        assertEquals(
            setOf(
                Move(Position.a1, Position.a2),
                Move(Position.a1, Position.b1),
                Move(Position.a1, Position.b2),
            ),
            moves.toSet()
        )
    }

    @Test
    fun moveKingWithCastling() {
        val king = King(Position.e1, Piece.WHITE)
        assertEquals(
            setOf(
                Move(Position.e1, Position.d1),
                Move(Position.e1, Position.d2),
                Move(Position.e1, Position.e2),
                Move(Position.e1, Position.f1),
                Move(Position.e1, Position.f2),
                // CastleMoves
                Move(Position.e1, Position.c1),
                Move(Position.e1, Position.g1),
            ),
            king.pseudoLegalMoves().toSet()
        )
    }
}
