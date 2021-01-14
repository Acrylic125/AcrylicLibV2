package com.acrylic

import java.util.*
import java.util.regex.Pattern
import kotlin.collections.ArrayList

abstract class Command(command: String) {

    val command: String = command.split(ARGUMENT_SEPARATOR)[0]
    val id: String = toComparableCommandStr(this.command)
    val aliases: List<String>
    val arguments: List<Command>

    init {
        this.aliases = ArrayList()
        this.arguments = ArrayList()
    }

    fun isThisCommand(commandInput: CommandInput): Boolean {
        return commandInput.id == this.id
    }

    abstract fun executeCommand(commandExecuted: CommandExecuted)

    abstract fun preconditions(commandExecuted: CommandExecuted): Boolean

}

val ARGUMENT_SEPARATOR: Pattern = Pattern.compile(" ")

fun toComparableCommandStr(cmd: String): String {
    return cmd.toUpperCase(Locale.ENGLISH)
}