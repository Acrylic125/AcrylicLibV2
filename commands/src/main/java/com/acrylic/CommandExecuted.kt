package com.acrylic

import java.util.*
import kotlin.math.max
import kotlin.math.min

class CommandExecuted(val input: CommandInput) {

}

data class CommandInput(val input: String) {

    val mainCommand: String
    val fullCommand: List<String> = input.split(" ")

    init {
        this.mainCommand = fullCommand[0].toUpperCase(Locale.ENGLISH)
    }

    fun getArgument(index: Int): String {
        return fullCommand[max(0, min(fullCommand.size, index))]
    }

}