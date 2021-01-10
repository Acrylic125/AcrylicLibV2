import java.util.*

class Command : CommandBase {

}

class Argument : CommandBase {

}

abstract class CommandBase {

    val command: String
    abstract val permissions: Array<out String>
    val arguments: Array<out Argument>



}

data class CommandInput(val input: String) {

    val mainCommand: String
    val fullCommand: List<String> = input.split(" ")

    init {
        this.mainCommand = fullCommand[0].toUpperCase(Locale.ENGLISH)
    }

}