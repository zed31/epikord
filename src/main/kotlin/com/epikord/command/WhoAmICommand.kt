package com.epikord.command

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

class WhoAmICommand(event: MessageReceivedEvent?) : CmdHandler(event) {
    private val info = """
        Je suis un bot crée par @oken, je suis dans un repo publique sur github. Donc n'hésitez pas à faire des PR
        si vous avez des idées d'améliorations!
        Pour plus d'informations: https://github.com/zed31/epikord
    """.trimIndent()

    override fun run() {
        this.channel?.sendMessage(this.info)?.queue()
    }
}