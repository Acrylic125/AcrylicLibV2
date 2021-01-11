import java.util.function.Consumer
import kotlin.math.floor

interface Paginated<T> {

    var list: List<T>
    var elementsPerPage: Int

    fun getFirstPage(): Int {
        return 1
    }

    fun getLastPage(): Int {
        return floor((list.size.toDouble()) / elementsPerPage).toInt()
    }

    fun iterateElements(page: Int, action: Consumer<T>) {

    }

}
