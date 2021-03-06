package com.epikord.command

import net.dv8tion.jda.core.entities.Role
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * This abstract class contains all the needed information to handle role
 *
 * However is responsibility is not to know the specific role to add
 * @param event the returned event by JDA API
 * @param formattedCommand the formatted command
 */
class RoleHandler(event: MessageReceivedEvent?, formattedCommand: String) : CmdHandler(event) {

    /**
     * Logger used to write log on the user-defined output
     */
    private val logger: Logger? = LoggerFactory.getLogger(RoleHandler::class.java)

    /**
     * Controller used to handle the current guild
     */
    private val guildController = event?.guild?.controller

    /**
     * Current member which triggered the event
     */
    private val currentMember = event?.member

    /**
     * The JDA information
     */
    private val jda = event?.jda

    /**
     * The current role to add
     */
    private val role = formattedCommand

    /**
     * Add specific role to the current member
     * @param role the role to give to the user
     */
    override fun run() {
        logger?.info("${this.currentMember?.nickname} ask to add a role ${this.role} to his list of roles")
        val memberRoles = this.currentMember?.roles
        val currentRole : Role? = memberRoles?.find { it?.name == this.role }

        if (currentRole == null) {
            logger?.info("Role ${this.role} is not set to the member ${this.currentMember?.nickname} setting it")
            this.guildController?.addRolesToMember(this.currentMember, jda?.getRolesByName(this.role, true))?.queue()
            channel?.sendMessage("_Vous avez été ajouté à ${this.role}_")?.queue()
        } else {
            logger?.info("Role ${this.role} has already been set to the member ${this.currentMember?.nickname} erasing it")
            this.guildController?.removeRolesFromMember(this.currentMember, jda?.getRolesByName(this.role, true))?.queue()
            channel?.sendMessage("_Vous avez été supprimé de ${this.role}_")?.queue()
        }
    }
}