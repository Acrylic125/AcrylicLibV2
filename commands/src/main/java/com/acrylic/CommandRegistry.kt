package com.acrylic

import java.util.*
import kotlin.collections.ArrayList

interface CommandRegistry {

    val registered: Collection<Command>

    fun register(command: Command)

    fun unregister(command: Command)

    fun getCommand(id: String): Command? {
        val specifiedID = id.toUpperCase(Locale.ENGLISH)
        for (cmd in registered) {
            if (specifiedID == cmd.id)
                return cmd
        }
        return null
    }

}

class SimpleCommandRegistry : CommandRegistry {

    override val registered: MutableList<Command>

    constructor(registered: MutableList<Command>) {
        this.registered = registered
    }

    constructor() {
        this.registered = ArrayList()
    }

    override fun register(command: Command) {
        this.registered.add(command)
    }

    override fun unregister(command: Command) {
        this.registered.remove(command)
    }

}