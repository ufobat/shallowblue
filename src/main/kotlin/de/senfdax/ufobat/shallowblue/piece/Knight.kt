package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.SimpleMove

class Knight(position: Position) : Piece(position) {
    override fun pseudoLegalMoves(): List<Move> {
        return listOfNotNull(
            position?.north()?.north()?.let { listOf(it?.east(), it?.west()) },
            position?.west()?.west()?.let { listOf(it?.north(), it?.south()) },
            position?.south()?.south()?.let { listOf(it?.east(), it?.west()) },
            position?.east()?.east()?.let { listOf(it?.north(), it?.south()) },
        )
            .flatten()
            .filterNotNull()
            .map { SimpleMove(position, it) }
    }
}
