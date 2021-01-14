package com.acrylic

import java.util.*
import kotlin.math.max
import kotlin.math.min

open class CommandExecuted(val sender: CommandSender, val input: CommandInput) {

    var srcIndex = 0

    fun pushToNextArgument() {
        srcIndex++
    }

    fun getArgument(i: Int): String {
        return input.getArgument(srcIndex + i)
    }



}

data class CommandInput(val input: String) {

    val id: String
    val fullCommand: List<String> = input.split(" ")

    init {
        this.id = fullCommand[0].toUpperCase(Locale.ENGLISH)
    }

    fun getArgument(index: Int): String {
        return fullCommand[max(0, min(fullCommand.size, index))]
    }

}