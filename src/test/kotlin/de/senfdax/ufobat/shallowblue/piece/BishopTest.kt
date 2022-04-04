package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.SimpleMove
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BishopTest {

    @Test
    fun bishopCornerMove() {
        val bishop = Bishop(Position.a1, Piece.WHITE)
        val moves = bishop.pseudoLegalMoves()

        val expectation = listOf(
            Position.b2, Position.c3, Position.d4, Position.e5, Position.f6, Position.g7, Position.h8
        ).map { SimpleMove(Position.a1, it) }.toSet()

        assertEquals(expectation, moves.toSet())
    }

    @Test
    fun bishopSideMove() {
        val bishop = Bishop(Position.a3, Piece.WHITE)
        val moves = bishop.pseudoLegalMoves()

        val expectation = listOf(
            Position.b2, Position.c1,
            Position.b4, Position.c5, Position.d6, Position.e7, Position.f8
        ).map { SimpleMove(Position.a3, it) }.toSet()

        assertEquals(expectation, moves.toSet())
    }

    @Test
    fun bishopMiddleMove() {
        val bishop = Bishop(Position.d3, Piece.WHITE)
        val moves = bishop.pseudoLegalMoves()

        val expectation = listOf(
            Position.b1, Position.c2, Position.e4, Position.f5, Position.g6, Position.h7,
            Position.a6, Position.b5, Position.c4, Position.e2, Position.f1
        ).map { SimpleMove(Position.d3, it) }.toSet()

        assertEquals(expectation, moves.toSet())
    }
}
