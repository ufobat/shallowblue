package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.SimpleMove
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KingTest {

    @Test
    fun moveKingInTheCorner() {
        val king = King(Position.a1)
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
}
