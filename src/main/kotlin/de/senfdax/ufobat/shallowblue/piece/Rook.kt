package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Color
import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position

class Rook(position: Position, type: Color) : Piece(position, type) {
    override fun pseudoLegalMoves(): List<Move> {
        return (0..7)
            .flatMap { listOf(Position.fromCoordinates(it, position.row), Position.fromCoordinates(position.col, it)) }
            .filterNotNull()
            .filterNot { it == position }
            .map { Move(position, it) }
    }

    override fun moveTo(dest: Position): Piece = Queen(dest, type)
}
