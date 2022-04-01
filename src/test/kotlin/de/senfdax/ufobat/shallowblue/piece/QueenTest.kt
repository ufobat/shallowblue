package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.SimpleMove
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class QueenTest {

    @Test
    fun queenCornerMoves() {
        val queen = Queen(Position.h8)
        val moves = queen.pseudoLegalMoves()

        val expectation = listOf(
            Position.h1, Position.h2, Position.h3, Position.h4, Position.h5, Position.h6, Position.h7,
            Position.a8, Position.b8, Position.c8, Position.d8, Position.e8, Position.f8, Position.g8,
            Position.a1, Position.b2, Position.c3, Position.d4, Position.e5, Position.f6, Position.g7,
        )
            .map { SimpleMove(Position.h8, it) }
            .toSet()

        // assertEquals(expectation.count(), moves.count())
        assertEquals(expectation, moves.toSet() )
    }
}
