package de.senfdax.ufobat.shallowblue

import de.senfdax.ufobat.shallowblue.piece.Pawn

class Board(
    val whitePieces: List<Piece>,
    val blackPieces: List<Piece>,
    val whoIsNext: Color = Piece.WHITE,
    val lastMoves : List<Move> = listOf(),
    ) {

    private val importantMovedPices: Map<Position, Boolean> = mapOf()
    private fun hasMoved(pos: Position) = importantMovedPices.getOrDefault(pos, false)


    fun applyMove(move: Move) : Board? {
        // Step 1 - Who's turn?
        val (me, opponent) = if(whoIsNext == Piece.WHITE)
            whitePieces to blackPieces
        else
            blackPieces to whitePieces

        // Step 2 - find out moving piece?
        val piece = me.firstOrNull { it.position == move.from } ?: return null
        // Step 3 - is a pseudoLegalMove
        if (piece.pseudoLegalMoves().contains(move)) {

            // Step 4 - Detect Type of Move and execute it
            return makeMove(piece, move, me, opponent)
        }
        return null
    }

    private fun makeMove(piece: Piece, move: Move, me: List<Piece>, opponent: List<Piece>) : Board? {
        // Detect Move Types
        // 1) Castling
        if (move.isCastling() && piece is Pawn) {
            val rookPosition = getCastlingRookPos(move)
            if ( !hasMoved(move.from) && !hasMoved(rookPosition) ) {
                // lets go! Move King && Move Rook
                val rook: Piece = me.first { it.position == rookPosition }

            }
        }
        // 2) En passant
        // 3) Promotion
        // 4) Normal Capture
        // 5) Normal Move

        // 6) After Moves: Was Figure Pinned?!

        if (isAValidMove(piece, move, me, opponent)) {
            return executeMove(piece, move, me, opponent)
        }
    }

    private fun getCastlingRookPos(move: Move): Position {
        val rookPosition = if (move.dest == Position.c1)
            Position.a1
        else if ( move.dest == Position.g1)
            Position.a8
        else if ( move.dest == Position.c8)
            Position.a8
        else
            Position.h8
    }

    Private fun isAValidMove(piece: Piece, move: Move, me: List<Piece>, opponent: List<Piece>) : Boolean {
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
