package com.acrylic

interface CommandRegistry<T : Command> {

    fun getAllCommands(): Collection<T>

    fun register(command: T)

    fun unregister(command: T)

    fun unregister(cmd: String)

    fun getCommand(cmd: String): T?

}

class SimpleCommandRegistry(val registered: MutableList<Command>) : CommandRegistry<Command> {

    constructor() : this(ArrayList())

    override fun register(command: Command) {
        registered.add(command)
    }

    override fun unregister(command: Command) {
        registered.remove(command)
    }

    override fun unregister(cmd: String) {
        val command = getCommand(cmd)
        if (command != null)
            unregister(command)
    }

    override fun getCommand(cmd: String): Command? {
        val comparableCMD = toComparableCommandStr(cmd)
        for (command in registered) {
            if (command.id == comparableCMD)
                return command
        }
        return null
    }

    override fun getAllCommands(): Collection<Command> {
        return registered
    }

}