package com.epikord.command

import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Class used to handle an Help command
 *
 * @param event the message received event coming from the JDA API
 * @param formattedCmd the formatted command
 */
class HelpCommand(event: MessageReceivedEvent?) : CmdHandler(event) {

    /**
     * Logger used to log on the specific user-defined output
     */
    val logger: Logger? = LoggerFactory.getLogger(HelpCommand::class.java)

    /**
     * Help message
     */
    private val helpInfo = """
        Ce bot permet de rejoindre les canaux privés en fonction de vos différentes préférences:

        ?${Command.PGT2.name}      -       Vous ajoute aux différents canaux de PGT2
        ?${Command.PGT3.name}      -       Vous ajoute aux différents canaux de PGT3
        ?${Command.PGT4Swa.name}   -       Vous ajoute aux différents canaux de PGT4 Software Architecture
        ?${Command.PGT5Swa.name}   -       Vous ajoute aux différents canaux de PGT5 Software Architecture
        ?${Command.PGT4Net.name}   -       Vous ajoute aux différents canaux de PGT4 Network
        ?${Command.PGT5Net.name}   -       Vous ajoute aux différents canaux de PGT5 Network

        Autres commandes utiles

        ?${Command.WhoAmI.name}     -       Je vous dit qui je suis réellement
        ?${Command.Help.name}       -       Affiche ce message
    """.trimIndent()

    /**
     * Run the help command
     *
     * Display the current channel and return
     */
    override fun run() {
        logger?.info("Help command detected")
        this.channel?.sendMessage(this.helpInfo)?.queue()
    }
}