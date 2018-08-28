package com.epikord.processor

import com.epikord.command.Command
import com.epikord.command.HelpCommand
import com.epikord.command.RoleHandler
import com.epikord.command.WhoAmICommand
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
        when (command) {
            Command.Help.name       -> HelpCommand(event).run()
            Command.WhoAmI.name     -> WhoAmICommand(event).run()
            Command.PGT2.name       -> RoleHandler(event, command).run()
            Command.PGT3.name       -> RoleHandler(event, command).run()
            Command.PGT4Swa.name    -> RoleHandler(event, command).run()
            Command.PGT4Net.name    -> RoleHandler(event, command).run()
            Command.PGT5Swa.name    -> RoleHandler(event, command).run()
            Command.PGT5Net.name    -> RoleHandler(event, command).run()
            else                    -> HelpCommand(event).run()
        }
    }
}