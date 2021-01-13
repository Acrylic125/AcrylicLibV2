package com.acrylic

interface CommandExecutor {

    val commandRegistry: CommandRegistry

    fun getCommandInput(input: String): CommandInput

}