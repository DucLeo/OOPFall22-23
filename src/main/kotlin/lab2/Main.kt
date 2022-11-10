package lab2

fun main() {
    do {
        println("Enter the path to the file or 'exit' to shut down: ")
        val path = readln()
        if (path != "exit") {
            try {
                val begin = System.currentTimeMillis()
                val data = ReadFiles(path)
                duplicate(data.addresses)
                storeyBuildings(data.addresses)
                val end = System.currentTimeMillis()
                println("Processing time: ${end - begin} milliseconds.")
            } catch (e: Exception) {
                println(e.message)
            }
        }
    } while (path != "exit")
}