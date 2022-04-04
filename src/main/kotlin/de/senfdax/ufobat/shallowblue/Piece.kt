package de.senfdax.ufobat.shallowblue

typealias Color = Boolean
abstract class Piece(val position: Position, val type: Color) {

    companion object {
        const val BLACK: Color = true
        const val WHITE: Color = false
    }
    abstract fun pseudoLegalMoves() : List<Move>
    abstract fun moveTo(dest: Position): Piece

    fun isBlack() : Boolean { return type == BLACK }
    fun isWhite() : Boolean { return type == WHITE }
}
