package de.senfdax.ufobat.shallowblue

class Starter {
    companion object {
        @JvmStatic
        fun main(argv: Array<String>) {

            val engine = ChessEngine()
            val protocolHandler = ProtocolHandler(engine)
            protocolHandler.process()
        }
    }
}
