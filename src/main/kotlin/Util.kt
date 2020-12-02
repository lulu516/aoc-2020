import java.io.File

fun readLines(fileName: String): List<String> = File("src/main/resource/$fileName").readLines()

fun readLine(fileName: String, separator: String): List<String> =
    File("src/main/resource/$fileName").readText().replace("\n", "").split(separator)

fun vis(graph: List<List<String>>) {
    println(graph.map { it.joinToString(" ") }.joinToString("\n"))
}

fun vis(routes: List<Pair<Int, Int>>, colors: List<Int>) {
    val xmin = routes.map { it.first }.min()!!
    val ymin = routes.map { it.second }.min()!!

    val xmax = routes.map { it.first }.max()!!
    val ymax = routes.map { it.second }.max()!!

    val result = mutableListOf<List<Int>>()

    for (y in ymax downTo ymin) {
        val xlist = mutableListOf<Int>()
        for (x in xmin..xmax) {
            var color = 0
            if (routes.contains(Pair(x, y))) {
                color = colors[routes.lastIndexOf(Pair(x, y))]
            }
            xlist.add(color)
        }

        result.add(xlist)
    }

    val joinToString = result.map { it.joinToString("") }.joinToString("\n")

    println(joinToString)
}
