package de.senfdax.ufobat.shallowblue

abstract class Piece(val position: Position) {
    abstract fun pseudoLegalMoves() : List<Move>
}
