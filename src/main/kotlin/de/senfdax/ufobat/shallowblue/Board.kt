package de.senfdax.ufobat.shallowblue

import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.piece.Pawn

class Board(
    val whitePieces: List<Piece>,
    val blackPieces: List<Piece>,
    val whoIsNext: Color = Piece.WHITE,
    val lastMoves : List<Move> = listOf(),
) {

    fun applyMove(move: Move) : Board? {
        val (me, opponent) = if(whoIsNext == Piece.WHITE)
            whitePieces to blackPieces
        else
            blackPieces to whitePieces

        return makeMove(move, me, opponent)
    }

    private fun makeMove(move: Move, me: List<Piece>, opponent: List<Piece>) : Board? {
        val piece = me.first { it.position == move.from }
        // check if pseudo legal
        // check if really legal
        // execute it
        if( piece.pseudoLegalMoves().contains(move) ) {
            if (isAValidMove(piece, move, me, opponent)) {
                return executeMove(piece, move, me, opponent)
            }
        }
        return null
    }

    private fun isAValidMove(piece: Piece, move: Move, me: List<Piece>, opponent: List<Piece>) : Boolean {
        // check if really legal: attack with en passant
        if(piece is Pawn) {
            // e.g a white pawn on d5 captures a black pawn that moved to e5 (4th row)
            // with a move to e6 ( e6 is in the 5th row)
            if(piece.isWhite() && move.dest.row == 5) {
                val enemy = opponent.first { it.position == move.dest }
                return if (enemy != null) {
                    true
                } else {
                    val realEnemy = opponent.first { it.position == Position.fromCoordinates(move.dest.col, 4) }
                    val lastMove = lastMoves.last()!!
                    // en passant condition:
                    realEnemy != null && realEnemy is Pawn && lastMove.dest == realEnemy.position
                }
            }
        }

        // check if really legal: attack but pinned
        // TODO: find king, check is king is attacked if the move is executed
        // val potentialBoard = executeMove()
        // potentialBoard.isCheck()

        // after all conditions checked. -> true
        return true
    }

    private fun executeMove(piece: Piece, move: Move, me: List<Piece>, opponent: List<Piece>) : Board {
        val captured = opponent.first { it.position == move.dest }
        val newOoponent = opponent.filterNot { it == captured }
        val newMe = me.filterNot { it == piece } + piece.moveTo(move.dest)

        return if (piece.isWhite())
            Board(newMe, newOoponent, Piece.BLACK)
        else
            Board(newOoponent, newMe, Piece.WHITE)
    }
}
