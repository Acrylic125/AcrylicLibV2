package com.acrylic

import java.lang.IllegalArgumentException

data class CommandInput(val input: String) {

    val id: String
    val arguments: Array<String>
    val command: String

    init {
        val strs = input.split(ARGUMENT_SEPARATOR)
        arguments = Array(strs.size){""}
        command = strs[0]
        id = toComparableCommandStr(command)
        for ((i, str) in strs.withIndex()) {
            if (i <= 0)
                continue
            arguments[i] = str
        }
    }

}

class CommandExecuted {

    val sender: CommandSender
    val commandInput: CommandInput
    val args: Array<String>

    constructor(sender: CommandSender, commandInput: CommandInput) : this(sender, commandInput, commandInput.arguments.clone())

    constructor(sender: CommandSender, commandInput: CommandInput, args: Array<String>) {
        this.sender = sender
        this.commandInput = commandInput
        this.args = args
    }

    private fun getSafeIndex(index: Int): Int {
        return (args.size - 1).coerceAtLeast(0.coerceAtMost(index))
    }

    fun getArgument(index: Int): String {
        return this.args[getSafeIndex(index)]
    }

    fun getArguments(indexFrom: Int, indexTo: Int): Array<String> {
        val iF = getSafeIndex(indexFrom)
        val iT = getSafeIndex(indexTo)
        if (iT < iF)
            throw IllegalArgumentException("The specified index to must be greater than or equal to the starting index.")
        val args = Array(iT - iF + 1){""}
        for ((c, i) in (iF..iT).withIndex())
            args[c] = this.args[i]
        return args
    }

    fun getArgumentsFrom(index: Int): Array<String> {
        return getArguments(index, args.size - 1)
    }

}
