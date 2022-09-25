package lab1

import java.net.URI
import java.net.URL
import java.net.URLEncoder
import com.google.gson.*
import java.awt.Desktop

class WikiRequest(private var request: String) {
    private val requestLink = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="
    private val resultLink = "https://ru.wikipedia.org/w/index.php?curid="
    val results: List<WikiResult>

    init {
        request = URLEncoder.encode(request, "UTF-8")
        val jsonString = URL(requestLink + "\"$request\"").readText()
        results = getResults(jsonString)
    }

    private fun getResults(jsonString: String): List<WikiResult> {
        val jsonArray = Gson()
            .fromJson(jsonString, JsonObject::class.java)
            .getAsJsonObject("query")
            .getAsJsonArray("search")

        val results = emptyList<WikiResult>().toMutableList()

        jsonArray.forEach {
            results.add(
                WikiResult(
                    it.asJsonObject.getAsJsonPrimitive("title").toString(),
                    it.asJsonObject.getAsJsonPrimitive("pageid").toString()
                )
            )
        }
        return results
    }

    fun openWiki(id: Int) {
        Desktop.getDesktop().browse(URI(resultLink + results[id].pageId))
    }
}