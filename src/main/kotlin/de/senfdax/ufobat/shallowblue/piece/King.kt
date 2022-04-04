package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Color
import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position

class King(position: Position, type: Color) : Piece(position, type) {
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
            .map { Move(position, it) }

        val castleMoves =
            if (position == Position.e1) {
                listOf(Move(position, Position.c1), Move(position, Position.g1))
            } else listOf()

        return simpleMoves + castleMoves
    }

    override fun moveTo(dest: Position): Piece = King(dest, type)
}
