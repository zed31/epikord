package com.epikord.command

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Class used to handle commands coming from the Discord bot
 *
 * @param event the received event from the JDA API
 * @param formattedCmd the formatted command being handled
 */
abstract class CmdHandler(event: MessageReceivedEvent?) {
    val channel = event?.channel
    /**
     * Called by the listener to run the specific command
     */
    abstract fun run()
}