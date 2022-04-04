package de.senfdax.ufobat.shallowblue

import kotlin.reflect.KClass

data class Move(
    val from: Position,
    val dest: Position,
    val promotionTo: KClass<*>? = null
) {

    fun isCastling(): Boolean {
        if (from == Position.e1 && (dest == Position.c1 || dest == Position.f1))
            return true
        if (from == Position.e8 && (dest == Position.c8 || dest == Position.f8))
            return true
        return false
    }
}
