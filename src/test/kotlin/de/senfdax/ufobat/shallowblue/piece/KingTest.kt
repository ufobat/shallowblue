package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.CastleMove
import de.senfdax.ufobat.shallowblue.move.SimpleMove
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KingTest {

    @Test
    fun moveKingInTheCorner() {
        val king = King(Position.a1, Piece.WHITE)
        val moves = king.pseudoLegalMoves()
        assertEquals(
            setOf(
                SimpleMove(Position.a1, Position.a2),
                SimpleMove(Position.a1, Position.b1),
                SimpleMove(Position.a1, Position.b2),
            ),
            moves.toSet()
        )
    }

    @Test
    fun moveKingWithCastling() {
        val king = King(Position.e1, Piece.WHITE)
        assertEquals(
            setOf(
                SimpleMove(Position.e1, Position.d1),
                SimpleMove(Position.e1, Position.d2),
                SimpleMove(Position.e1, Position.e2),
                SimpleMove(Position.e1, Position.f1),
                SimpleMove(Position.e1, Position.f2),
                CastleMove(Position.a1),
                CastleMove(Position.h1),
            ),
            king.pseudoLegalMoves().toSet()
        )
    }
}
