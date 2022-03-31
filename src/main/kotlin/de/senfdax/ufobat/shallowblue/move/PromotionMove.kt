package de.senfdax.ufobat.shallowblue.move

import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Position
import kotlin.reflect.KClass

data class PromotionMove(val from: Position, val dest: Position, val kClass: KClass<*>) : Move
