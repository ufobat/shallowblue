package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.SimpleMove

class King(position: Position) : Piece(position) {
    override fun pseudoLegalMoves(): List<SimpleMove> {
        val positions = (-1..1).flatMap { x ->
            (-1 .. 1).map { y ->
                if (y!=0 || x != 0)
                    Position.fromCoordinates(position.row + x, position.col + y)
                else
                    null
            }
        }

        return positions
            .filterNotNull()
            .map { SimpleMove(position, it) }
    }
}
