package com.acrylic

interface CommandExecutor {

    val commandRegistry: CommandRegistry

    fun execute(sender: CommandSender, input: String)

    fun seekCommand(inputCommand: CommandInput): Command?

}

class SimpleCommandExecutor : CommandExecutor {

    override val commandRegistry: CommandRegistry

    constructor() {
        this.commandRegistry = SimpleCommandRegistry()
    }

    constructor(commandRegistry: CommandRegistry) {
        this.commandRegistry = commandRegistry
    }

    override fun execute(sender: CommandSender, input: String) {
        val inputCommand = CommandInput(input)
        val command = seekCommand(inputCommand)

    }

    override fun seekCommand(inputCommand: CommandInput): Command? {
        for (command in commandRegistry.registered) {
            if (command.isThisCommand(inputCommand))
                return command
        }
        return null
    }

}