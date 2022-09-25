import lab1.WikiRequest

fun main() {
    println("Enter search:")

    val input = readln()
    val request = WikiRequest(input)

    println("\nResults for \"$input\": ")
    request.results.forEachIndexed { index, result -> println("$index. $result") }

    println("\nEnter number to open: ")
    try {
        val index = readln().toInt()
        request.openWiki(index)
    } catch (_: NumberFormatException) {
        println("Entered string is not a number. ")
    } catch (_: IndexOutOfBoundsException) {
        println("Index is out of range.")
    }
}