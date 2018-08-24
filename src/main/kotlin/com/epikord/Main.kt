package com.epikord

import com.beust.klaxon.Klaxon
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody
import com.epikord.configuration.ArgConfig
import com.epikord.listeners.ReadyListener
import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder
import com.epikord.configuration.DiscordData
import java.io.File

/**
 * Main function of the program
 * This function parse the whole list of arguments and the com.epikord.configuration file
 * to get the discord token and run the Discord API
 */
fun main(args: Array<String>) = mainBody {
    ArgParser(args).parseInto(::ArgConfig).run {
        println("Setup the configuration file to $config")
        val configFile = File(this.config)

        if (!configFile.exists()) {
            println("$config not found, returning")
            return@run
        }

        val discordData = Klaxon().parse<DiscordData>(configFile)
        JDABuilder(AccountType.BOT).setToken(discordData?.token).addEventListener(ReadyListener()).buildBlocking()
    }
}
