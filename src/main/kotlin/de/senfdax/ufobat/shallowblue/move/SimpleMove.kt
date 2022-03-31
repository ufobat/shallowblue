package de.senfdax.ufobat.shallowblue.move

import de.senfdax.ufobat.shallowblue.Move
import de.senfdax.ufobat.shallowblue.Position

data class SimpleMove(val from: Position, val dest: Position) : Move
