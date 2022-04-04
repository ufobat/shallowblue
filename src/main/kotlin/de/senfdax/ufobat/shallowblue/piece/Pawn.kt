package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Color
import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position

class Pawn(pos: Position, type: Color) : Piece(pos, type) {

    // what about black pawns?
    private fun movesToDestination(destination: Position): Set<Move> {
        val result = mutableSetOf<Move>()
        // pawns of the wrong color can not move to 0 or 7
        if (destination.row == 0 || destination.row == 7) {
            result.add(Move(position, destination, Queen::class))
            result.add(Move(position, destination, Rook::class))
            result.add(Move(position, destination, Bishop::class))
            result.add(Move(position, destination, Knight::class))
        } else {
            result.add(Move(position, destination))
        }
        return result
    }

    private fun forward() : Position? {
        return if (isWhite()) this.position.north() else this.position.south()
    }

    override fun pseudoLegalMoves(): List<Move> {
        val result = mutableListOf<Move>()

        val oneStepAhead = forward()!!
        result.addAll(movesToDestination(oneStepAhead))
        // white left or black right
        oneStepAhead.west() ?.also {  result.addAll(movesToDestination(it)) }

        // white right or black left attack
        oneStepAhead.east() ?.also {  result.addAll(movesToDestination(it)) }

        if (isWhite() && position.row == 1) {
            result.add(Move(position, oneStepAhead.north()!!))
        } else if (isBlack() && position.row == 6) {
            result.add(Move(position, oneStepAhead.south()!!))
        }
        return result
    }

    override fun moveTo(dest: Position) = Pawn(dest, type)
}

