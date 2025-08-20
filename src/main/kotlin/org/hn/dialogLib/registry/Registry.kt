package org.hn.dialogLib.registry

import net.kyori.adventure.key.Key
import java.util.concurrent.ConcurrentHashMap

open class Registry<T> {

    private val values = ConcurrentHashMap<String, () -> T>()

    open fun register(id: String, value: () -> T): Registry<T> {
        require(!containsKey(id)) { "Registry already contains an entry with id $id" }
        values[id] = value
        return this
    }

    open fun register(key: Key, value: () -> T): Registry<T> {
        require(!containsKey(key.toString())) { "Registry already contains an entry with id $key" }
        values[key.toString()] = value
        return this
    }

    fun containsKey(id: String): Boolean {
        return values.containsKey(id)
    }

    fun get(id: String): T? {
        return values[id]?.invoke()
    }

    fun get(key: Key): T? {
        return values[key.toString()]?.invoke()
    }

    fun getValues(): List<T> {
        return values.values.map { it.invoke() }
    }

    fun clear() {
        values.clear()
    }
}