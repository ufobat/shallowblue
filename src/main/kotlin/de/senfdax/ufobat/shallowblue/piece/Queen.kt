package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.SimpleMove

class Queen(position: Position) : Piece(position) {
    override fun pseudoLegalMoves(): List<Move> {
        // Rook Movements
        val rook = (0..7).flatMap {
            listOf(
                Position.fromCoordinates(it, position.row),
                Position.fromCoordinates(position.col, it)
            )
        }
            .filterNotNull()
            .filterNot { it == position }

        // Bishop Movements
        val bishop = (-7..7).flatMap {
            if (it != 0)
                listOf(
                    Position.fromCoordinates(position.col + it, position.row + it),
                    Position.fromCoordinates(position.col + it, position.row - it)
                )
             else listOf()
        }.filterNotNull()

        return (rook + bishop).map { SimpleMove(position,it) }
    }
}
