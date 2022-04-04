package de.senfdax.ufobat.shallowblue

import de.senfdax.ufobat.shallowblue.piece.King
import de.senfdax.ufobat.shallowblue.piece.Pawn
import de.senfdax.ufobat.shallowblue.piece.Queen
import de.senfdax.ufobat.shallowblue.piece.Rook
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

@Disabled
class BoardTest {

    @Test
    fun simpleMoveOnABoard() {
        val whitePieces = listOf(
            Pawn(Position.a2, Piece.WHITE)
        )
        val blackPieces = listOf(
            Pawn(Position.h7, Piece.BLACK)
        )
        val board = Board(whitePieces, blackPieces)
        val newBoard = board.applyMove(Move(Position.a2, Position.a4))
        assertEquals(Position.a4, newBoard!!.whitePieces[0].position)
        assertEquals(Position.h7, newBoard!!.blackPieces[0].position)
    }

    @Test
    fun moveOfaNotExistingPieceOnABoard() {
        val board = Board(listOf(), listOf())
        val newBoard = board.applyMove(Move(Position.a2, Position.a4))
        assertNull(newBoard)
    }

    @Test
    fun shortCastleMoveThatWorks() {
        val board = Board(
            listOf(King(Position.e1, Piece.WHITE), Rook(Position.a1, Piece.WHITE)),
            listOf()
        )
        val newBoard = board.applyMove(Move(Position.e1, Position.c1))
        assertEquals(
            setOf(King(Position.c1, Piece.WHITE), Rook(Position.d1, Piece.WHITE)),
            newBoard!!.whitePieces.toSet()
        )
    }

    @Test
    fun longCastleMoveThatWorks() {
        val board = Board(
            listOf(King(Position.e1, Piece.WHITE), Rook(Position.h1, Piece.WHITE)),
            listOf()
        )
        val newBoard = board.applyMove(Move(Position.e1, Position.g1))
        assertEquals(
            setOf(King(Position.g1,Piece.WHITE), Rook(Position.f1, Piece.WHITE)),
            newBoard!!.whitePieces.toSet()
        )
    }

    @Test
    fun promotionMove() {
        val board = Board(listOf(), listOf(Pawn(Position.h2, Piece.BLACK)))
        val newBoard = board.applyMove(Move(Position.h2, Position.h1, Queen::class))
        assertEquals(Queen(Position.h1, Piece.BLACK), newBoard!!.blackPieces[0])
    }

    @Test
    fun afterWhiteNextTurnIsBlack() {
        TODO()
    }

    @Test
    fun afterBlackNextTurnIsWhite() {
        TODO()
    }
}
