package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Color
import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.PromotionMove
import de.senfdax.ufobat.shallowblue.move.SimpleMove
import javax.print.attribute.standard.Destination

class Pawn(pos: Position, type: Color) : Piece(pos, type) {

    // what about black pawns?
    private fun movesToDestination(destination: Position): Set<Move> {
        val result = mutableSetOf<Move>()
        if(position.row == 6) {
            result.add(PromotionMove(position, destination, Queen::class))
            result.add(PromotionMove(position, destination, Rook::class))
            result.add(PromotionMove(position, destination, Bishop::class))
            result.add(PromotionMove(position, destination, Knight::class))
        } else {
            result.add(SimpleMove(position, destination))
        }
        return result
    }

    override fun pseudoLegalMoves(): List<Move> {
        val result = mutableListOf<Move>()

        if (position.row + 1 < 8) {
            // can move a step forward

            // move forward
            val oneStepAhead = position.north()!!
            result.addAll(movesToDestination(oneStepAhead))

            // left attack
            oneStepAhead.west() ?.also {  result.addAll(movesToDestination(it)) }

            // right attack
            oneStepAhead.east() ?.also {  result.addAll(movesToDestination(it)) }

            if (position.row == 1) {
                // 2 steps are allowed if you on the row 2
                result.add(SimpleMove(position, oneStepAhead.north()!!))
            }
        }
        return result
    }

    override fun moveTo(dest: Position) = Pawn(dest, type)
}

