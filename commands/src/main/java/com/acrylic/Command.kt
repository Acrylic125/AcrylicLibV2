package com.acrylic

import java.util.*
import kotlin.collections.ArrayList

abstract class Command(command: String) : CommandBase(command) {

    fun isThisCommand(input: CommandInput): Boolean {
        return input.id == this.id
    }

}


abstract class Argument(command: String) : CommandBase(command) {

    fun isThisArgument(input: CommandInput): Boolean {
        return input.id == this.id
    }

}

abstract class CommandBase(val command: String) {

    val id: String = this.command.split(" ")[0].toUpperCase(Locale.ENGLISH)
    val permissions: List<String> = ArrayList()
    val arguments: List<Argument> = ArrayList()
    val aliases: List<String> = ArrayList()

    abstract fun execute(commandExecuted: CommandExecuted)

}
