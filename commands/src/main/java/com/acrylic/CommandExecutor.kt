package com.acrylic

interface CommandExecutor<T : Command> {

    val commandRegistry: CommandRegistry<T>

    fun tryToExecute(sender: CommandSender, input: String): Boolean

}

class SimpleCommandExecutor(override val commandRegistry: CommandRegistry<Command>) : CommandExecutor<Command> {

    constructor() : this(SimpleCommandRegistry())

    override fun tryToExecute(sender: CommandSender, input: String): Boolean {
        val command = commandRegistry.getCommand(input)
        if (command != null) {

            return true
        }
        return false
    }
}


