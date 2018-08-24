package com.epikord.listeners

import net.dv8tion.jda.core.events.Event
import net.dv8tion.jda.core.events.ReadyEvent
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.EventListener

/**
 * Listener used to tell us when the API is ready
 */
class ReadyListener : EventListener {
    /**
     * Override function called by the JDA engine when an event is fired
     * @param event the event variable which tells us which event is present
     */
    override fun onEvent(event: Event?) {
        when (event) {
            is ReadyEvent -> println("API is ready")
            is MessageReceivedEvent -> this.handleReceivedMessage(event)
        }
    }

    /**
     * Make an action when a message is received
     * @param event the received event message
     */
    private fun handleReceivedMessage(event: MessageReceivedEvent?) {
        if (event?.author!!.isBot) {
            return
        }
        val msg = event.message!!.contentRaw
        println("$msg")
    }
}