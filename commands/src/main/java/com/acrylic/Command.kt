package com.acrylic

import java.util.*
import kotlin.collections.ArrayList

class Command(command: String) : CommandBase(command) {

    fun isThisCommand(input: CommandInput): Boolean {
        return input.mainCommand == this.id
    }

}

class Argument(command: String) : CommandBase(command) {

    fun isThisArgument(input: CommandInput): Boolean {
        return input.mainCommand == this.id
    }

}

abstract class CommandBase(val command: String) {

    val id: String = this.command.toUpperCase(Locale.ENGLISH)
    val permissions: List<String> = ArrayList()
    val arguments: List<Argument> = ArrayList()

}
