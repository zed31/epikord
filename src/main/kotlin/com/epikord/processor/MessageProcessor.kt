package com.epikord.processor

import com.epikord.command.HelpCommand
import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Class used to process received message
 */
class MessageProcessor {
    /**
     * Function used to handle message
     * @param event event used to retrieve the message
     */
    fun handleMessage(event: MessageReceivedEvent?) {
        if (event?.author!!.isBot) {
            return
        }
        val msg = event.message!!.contentRaw
        if (!msg.startsWith("?")) {
            return
        }
        val command = msg.substring(1, msg.length)
        println("command received: $command")
        when (command) {
            "help" -> HelpCommand(event, command).run()
        }
    }
}