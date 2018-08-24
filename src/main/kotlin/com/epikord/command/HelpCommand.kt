package com.epikord.command

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Class used to handle an Help command
 *
 * @param event the message received event coming from the JDA API
 * @param formattedCmd the formatted command
 */
class HelpCommand(event: MessageReceivedEvent?, formattedCmd: String) : CmdHandler(event, formattedCmd) {

    /**
     * Help message
     */
    private val helpInfo = """
        Ce bot permet de rejoindre les canaux privés en fonction de vos différentes préférences:
        ?PGT2       -       Vous ajoute aux différents canaux de PGT2
        ?PGT3       -       Vous ajoute aux différents canaux de PGT3
        ?PGT4-SWA   -       Vous ajoute aux différents canaux de PGT4 Software Architecture
        ?PGT5-SWA   -       Vous ajoute aux différents canaux de PGT5 Software Architecture
        ?PGT4-NET   -       Vous ajoute aux différents canaux de PGT4 Network
        ?PGT5-NET   -       Vous ajoute aux différents canaux de PGT5 Network
    """.trimIndent()

    /**
     * Run the help command
     *
     * Display the current channel and return
     */
    override fun run() {
        this.channel?.sendMessage(this.helpInfo)?.queue()
    }
}