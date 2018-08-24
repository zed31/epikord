package com.epikord.configuration

import com.xenomachina.argparser.ArgParser

class ArgConfig(parser: ArgParser) {
    val config by parser.storing("-c", "--config", help = "setup the com.epikord.configuration file")
}