class Day2 {
    private val regex = """(\d+)-(\d+) ([a-z]): (.+)""".toRegex()

    fun part1() {
        readLines("day2").filter {
            val (min, max, l, pwd) = regex.find(it)!!.destructured
            val diff = pwd.length - pwd.replace(l, "").length
            diff in (min.toInt()..max.toInt())
        }.size.let { println(it) }
    }

    fun part2() {
        readLines("day2")
            .filter {
                val (min, max, l, pwd) = regex.find(it)!!.destructured
                val first = pwd[min.toInt() - 1].toString()
                val second = pwd[max.toInt() - 1].toString()
                (l == first || l == second) && first != second
            }.size.let { println(it) }
    }
}
