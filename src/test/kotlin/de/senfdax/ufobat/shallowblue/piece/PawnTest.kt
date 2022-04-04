package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Piece
import de.senfdax.ufobat.shallowblue.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PawnTest {

    @Test
    fun randomWhitePawnMoves() {
        val pawn = Pawn(Position.e4, Piece.WHITE)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(3, pseudoLegalMoves.count())
        pseudoLegalMoves.forEach {
            assertTrue(it is Move)
        }
        assertEquals(
            listOf(Position.e5, Position.d5, Position.f5).sorted(),
            pseudoLegalMoves.map { it.dest }.sorted()
        )
    }

    @Test
    fun randomBlackPawnMoves() {
        val pawn = Pawn(Position.e4, Piece.BLACK)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(3, pseudoLegalMoves.count())
        assertEquals(
            listOf(Position.e3, Position.d3, Position.f3).sorted(),
            pseudoLegalMoves.map { it.dest }.sorted()
        )
    }

    @Test
    fun startingWhitePawnMoves() {
        val pawn = Pawn(Position.e2, Piece.WHITE)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(4, pseudoLegalMoves.count())
        assertEquals(
            listOf(Position.e3, Position.e4, Position.d3, Position.f3).sorted(),
            pseudoLegalMoves.map { it.dest }.sorted()
        )
    }

    @Test
    fun startingBlackPawnMoves() {
        val pawn = Pawn(Position.e7, Piece.BLACK)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(4, pseudoLegalMoves.count())
        assertEquals(
            listOf(Position.e6, Position.e5, Position.d6, Position.f6).sorted(),
            pseudoLegalMoves.map { it.dest }.sorted()
        )
    }

    @Test
    fun promotingWhitePawnAtTheSide() {
        val pawn = Pawn(Position.h7, Piece.WHITE)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(
            setOf(
                Move(Position.h7, Position.g8, Queen::class),
                Move(Position.h7, Position.g8, Rook::class),
                Move(Position.h7, Position.g8, Bishop::class),
                Move(Position.h7, Position.g8, Knight::class),
                Move(Position.h7, Position.h8, Queen::class),
                Move(Position.h7, Position.h8, Rook::class),
                Move(Position.h7, Position.h8, Bishop::class),
                Move(Position.h7, Position.h8, Knight::class),
            ),
            pseudoLegalMoves.toSet()
        )
    }

    @Test
    fun promotingBlackPawnAtTheSide() {
        val pawn = Pawn(Position.h2, Piece.BLACK)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(
            setOf(
                Move(Position.h2, Position.g1, Queen::class),
                Move(Position.h2, Position.g1, Rook::class),
                Move(Position.h2, Position.g1, Bishop::class),
                Move(Position.h2, Position.g1, Knight::class),
                Move(Position.h2, Position.h1, Queen::class),
                Move(Position.h2, Position.h1, Rook::class),
                Move(Position.h2, Position.h1, Bishop::class),
                Move(Position.h2, Position.h1, Knight::class),
            ),
            pseudoLegalMoves.toSet()
        )

    }

    @Test
    fun promotingWhitePawn() {
        val pawn = Pawn(Position.d7, Piece.WHITE)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(
            setOf(
                Move(Position.d7, Position.d8, Queen::class),
                Move(Position.d7, Position.d8, Rook::class),
                Move(Position.d7, Position.d8, Bishop::class),
                Move(Position.d7, Position.d8, Knight::class),
                Move(Position.d7, Position.c8, Queen::class),
                Move(Position.d7, Position.c8, Rook::class),
                Move(Position.d7, Position.c8, Bishop::class),
                Move(Position.d7, Position.c8, Knight::class),
                Move(Position.d7, Position.e8, Queen::class),
                Move(Position.d7, Position.e8, Rook::class),
                Move(Position.d7, Position.e8, Bishop::class),
                Move(Position.d7, Position.e8, Knight::class),
            ),
            pseudoLegalMoves.toSet()
        )
    }
}
