package de.senfdax.ufobat.shallowblue

import kotlin.reflect.KClass

data class Move(
    val from: Position,
    val dest: Position,
    val promotionTo: KClass<*>? = null
)
