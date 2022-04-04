package de.senfdax.ufobat.shallowblue

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ProtocolHandler(engine: ChessEngine) {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun process() {
        logger.info("Started ProtocolHandler. Ready to server...")
        println("Chess")
        // Todo:
        /*
         xboard
         protover2
         force
         new
         random
         level 40 5 0
         post
         hard
         new
         */
        for (line in generateSequence(::readLine)) {
            logger.trace("processing $line")
        }
    }
}
