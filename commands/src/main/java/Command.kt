import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

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