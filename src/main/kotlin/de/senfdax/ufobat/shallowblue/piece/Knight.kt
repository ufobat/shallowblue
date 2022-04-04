package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Color
import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position

class Knight(position: Position, type: Color) : Piece(position, type) {
    override fun pseudoLegalMoves(): List<Move> {
        return listOfNotNull(
            position?.north()?.north()?.let { listOf(it?.east(), it?.west()) },
            position?.west()?.west()?.let { listOf(it?.north(), it?.south()) },
            position?.south()?.south()?.let { listOf(it?.east(), it?.west()) },
            position?.east()?.east()?.let { listOf(it?.north(), it?.south()) },
        )
            .flatten()
            .filterNotNull()
            .map { Move(position, it) }
    }

    override fun moveTo(dest: Position) = Knight(dest, type)
}
