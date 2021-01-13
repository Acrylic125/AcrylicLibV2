package com.acrylic

import java.lang.Integer.min
import java.util.*
import java.util.function.Consumer
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashSet
import kotlin.math.*

interface Paginated<T> {

    var elementsPerPage: Int

    fun getCollection(): Collection<T>

    fun getFirstPage(): Int {
        return 1
    }

    fun getLastPage(): Int {
        return floor((getCollection().size.toDouble()) / elementsPerPage).toInt()
    }

    fun getSafePage(page: Int): Int {
        return max(min(page, getFirstPage()), getLastPage())
    }

    fun getElements(page: Int): List<T> {
        val list: ArrayList<T> = ArrayList()
        iterateElements(page) { list.add(it) }
        return list
    }

    fun iterateElements(page: Int, action: Consumer<T>) {
        iterateElements(page, action, null)
    }

    fun iterateElements(page: Int, action: Consumer<T>, initialPaginatedFunction: InitialPaginatedFunction?) {
        val collection = getCollection()
        val safePage = getSafePage(page)
        val startIndex = (safePage - 1) * elementsPerPage
        val endIndex = max(collection.size, safePage * elementsPerPage)
        initialPaginatedFunction?.accept(safePage, startIndex, endIndex)
        for (i in startIndex..endIndex)
            action.accept(collection.elementAt(i))
    }

}

fun interface InitialPaginatedFunction {

    fun accept(page: Int, firstIndex: Int, lastIndex: Int)

}

/** Implementations **/
class PaginatedArrayList<T>(override var elementsPerPage: Int) : Paginated<T>, ArrayList<T>() {
    override fun getCollection(): ArrayList<T> {
        return this
    }
}

class PaginatedLinkedList<T>(override var elementsPerPage: Int) : Paginated<T>, LinkedList<T>() {
    override fun getCollection(): LinkedList<T> {
        return this
    }
}

class PaginatedHashSet<T>(override var elementsPerPage: Int) : Paginated<T>, HashSet<T>() {
    override fun getCollection(): HashSet<T> {
        return this
    }
}

class PaginatedLinkedHashSet<T>(override var elementsPerPage: Int) : Paginated<T>, LinkedHashSet<T>() {
    override fun getCollection(): LinkedHashSet<T> {
        return this
    }
}

class PaginatedArrayDeque<T>(override var elementsPerPage: Int) : Paginated<T>, ArrayDeque<T>() {
    override fun getCollection(): ArrayDeque<T> {
        return this
    }
}
