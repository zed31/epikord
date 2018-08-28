package com.epikord.command

import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class WhoAmICommand(event: MessageReceivedEvent?) : CmdHandler(event) {

    /**
     * Logger variable used to log on the specific output (defined in the properties)
     */
    val logger : Logger? = LoggerFactory.getLogger(WhoAmICommand::class.java)

    private val info = """
        Je suis un bot crée par @oken, je suis dans un repo publique sur github. Donc n'hésitez pas à faire des PR
        si vous avez des idées d'améliorations!
        Pour plus d'informations: https://github.com/zed31/epikord
    """.trimIndent()

    override fun run() {
        logger?.info("Who Am I command")
        this.channel?.sendMessage(this.info)?.queue()
    }
}