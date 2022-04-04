package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Color
import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.SimpleMove

class Bishop(position: Position, type: Color) : Piece(position, type) {
    override fun pseudoLegalMoves(): List<Move> {
        return (-7..7).flatMap {
            if (it != 0)
                listOf(
                    Position.fromCoordinates(position.col + it, position.row + it),
                    Position.fromCoordinates(position.col + it, position.row - it)
                )
             else listOf()
        }
            .filterNotNull()
            .map { SimpleMove(position, it) }
    }

    override fun moveTo(dest: Position): Piece = Bishop(dest, type)
}
