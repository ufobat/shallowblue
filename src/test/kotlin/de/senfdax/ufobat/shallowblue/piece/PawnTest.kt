package de.senfdax.ufobat.shallowblue.piece

import de.senfdax.ufobat.shallowblue.Position
import de.senfdax.ufobat.shallowblue.move.PromotionMove
import de.senfdax.ufobat.shallowblue.move.SimpleMove
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PawnTest {

    @Test
    fun randomPawnMoves() {
        val pawn = Pawn(Position.e4)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(3, pseudoLegalMoves.count())
        pseudoLegalMoves.forEach {
            assertTrue(it is SimpleMove)
        }
        assertEquals(
            listOf(Position.e5, Position.d5, Position.f5).sorted(),
            pseudoLegalMoves.map { (it as SimpleMove).dest }.sorted()
        )
    }

    @Test
    fun startingPawnMoves() {
        val pawn = Pawn(Position.e2)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(4, pseudoLegalMoves.count())
        pseudoLegalMoves.forEach {
            assertTrue(it is SimpleMove)
        }
        assertEquals(
            listOf(Position.e3, Position.e4, Position.d3, Position.f3).sorted(),
            pseudoLegalMoves.map { (it as SimpleMove).dest }.sorted()
        )
    }

    @Test
    fun promotingPawnAtTheSide() {
        val pawn = Pawn(Position.h7)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(
            setOf(
                PromotionMove(Position.h7, Position.g8, Queen::class),
                PromotionMove(Position.h7, Position.g8, Rook::class),
                PromotionMove(Position.h7, Position.g8, Bishop::class),
                PromotionMove(Position.h7, Position.g8, Knight::class),
                PromotionMove(Position.h7, Position.h8, Queen::class),
                PromotionMove(Position.h7, Position.h8, Rook::class),
                PromotionMove(Position.h7, Position.h8, Bishop::class),
                PromotionMove(Position.h7, Position.h8, Knight::class),
            ),
            pseudoLegalMoves.toSet()
        )

    }
    @Test
    fun promotingPawn() {
        val pawn = Pawn(Position.d7)
        val pseudoLegalMoves = pawn.pseudoLegalMoves()
        assertEquals(
            setOf(
                PromotionMove(Position.d7, Position.d8, Queen::class),
                PromotionMove(Position.d7, Position.d8, Rook::class),
                PromotionMove(Position.d7, Position.d8, Bishop::class),
                PromotionMove(Position.d7, Position.d8, Knight::class),
                PromotionMove(Position.d7, Position.c8, Queen::class),
                PromotionMove(Position.d7, Position.c8, Rook::class),
                PromotionMove(Position.d7, Position.c8, Bishop::class),
                PromotionMove(Position.d7, Position.c8, Knight::class),
                PromotionMove(Position.d7, Position.e8, Queen::class),
                PromotionMove(Position.d7, Position.e8, Rook::class),
                PromotionMove(Position.d7, Position.e8, Bishop::class),
                PromotionMove(Position.d7, Position.e8, Knight::class),
            ),
            pseudoLegalMoves.toSet()
        )

    }
}
