package com.acrylic

import java.util.*
import java.util.regex.Pattern
import kotlin.collections.ArrayList

abstract class Command(command: String, aliases: Array<String>, val arguments: Array<Command>) {

    val command: String = command.split(ARGUMENT_SEPARATOR)[0]
    val id: String = toComparableCommandStr(this.command)
    val aliases: Array<String> = emptyArray()

    init {
        for ((i, alias) in aliases.withIndex()) {
            this.aliases[i] = toComparableCommandStr(alias)
        }
    }

    fun isThisCommand(commandInput: CommandInput): Boolean {
        if (commandInput.id == this.id)
            return true
        for (alias in aliases) {
            if (commandInput.id == alias)
                return true
        }
        return false
    }

    abstract fun executeCommand(commandExecuted: CommandExecuted)

    abstract fun preconditions(commandExecuted: CommandExecuted): Boolean

}

val ARGUMENT_SEPARATOR: Pattern = Pattern.compile(" ")

fun toComparableCommandStr(cmd: String): String {
    return cmd.toUpperCase(Locale.ENGLISH)
}