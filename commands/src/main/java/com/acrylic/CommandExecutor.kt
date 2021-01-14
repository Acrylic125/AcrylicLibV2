package com.acrylic

interface CommandExecutor<T : Command> {

    val commandRegistry: CommandRegistry<T>

    fun tryToExecute(sender: CommandSender, input: String): Boolean {
        val command = commandRegistry.getCommand(input)
        if (command != null) {

            return true
        }
        return false
    }

}


