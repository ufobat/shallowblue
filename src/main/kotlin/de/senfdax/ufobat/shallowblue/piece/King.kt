package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.CastleMove
import de.senfdax.ufobat.shallowblue.move.SimpleMove

class King(position: Position) : Piece(position) {
    override fun pseudoLegalMoves(): List<Move> {
        val positions = (-1..1).flatMap { x ->
            (-1 .. 1).map { y ->
                if (y!=0 || x != 0)
                    Position.fromCoordinates(position.col + x, position.row + y)
                else
                    null
            }
        }

        val simpleMoves =  positions
            .filterNotNull()
            .map { SimpleMove(position, it) }

        val castleMoves =
            if (position == Position.e1) {
                listOf(CastleMove(Position.a1), CastleMove(Position.h1))
            } else listOf()

        return simpleMoves + castleMoves
    }
}
