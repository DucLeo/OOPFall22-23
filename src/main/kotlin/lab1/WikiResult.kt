package lab1

class WikiResult(private val pageTitle: String, val pageId: String) {
    override fun toString(): String {
        return "$pageId: \"$pageTitle\""
    }
}