package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.SimpleMove

class Rook(position: Position) : Piece(position) {
    override fun pseudoLegalMoves(): List<Move> {
        return (0..7)
            .flatMap { listOf(Position.fromCoordinates(it, position.row), Position.fromCoordinates(position.col, it)) }
            .filterNotNull()
            .filterNot { it == position }
            .map { SimpleMove(position, it) }
    }
}
