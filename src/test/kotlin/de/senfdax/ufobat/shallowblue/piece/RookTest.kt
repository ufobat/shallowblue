package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.SimpleMove
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RookTest {

    @Test
    fun rookCornerMoves() {
        val rook = Rook(Position.a8, Piece.WHITE)
        val moves = rook.pseudoLegalMoves()

        val expectation = listOf(
            Position.a1, Position.a2, Position.a3, Position.a4, Position.a5, Position.a6, Position.a7,
            Position.b8, Position.c8, Position.d8, Position.e8, Position.f8, Position.g8, Position.h8,
        ).map { SimpleMove(Position.a8, it) }.toSet()

        assertEquals(expectation, moves.toSet())
    }

    @Test
    fun rookMiddleMoves() {
        val rook = Rook(Position.b3, Piece.WHITE)
        val moves = rook.pseudoLegalMoves()

        val expectation = listOf(
            Position.b1, Position.b2, Position.b4, Position.b5, Position.b6, Position.b7, Position.b8,
            Position.a3, Position.c3, Position.d3, Position.e3, Position.f3, Position.g3, Position.h3
        ).map { SimpleMove(Position.b3, it) }.toSet()

        assertEquals(expectation, moves.toSet())
    }
}
