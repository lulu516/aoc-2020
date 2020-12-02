class Day1 {
    fun part1() {
        val input = readLines("day1").map { it.toInt() }
        for (elem in input) {
            val other = input.find { it == 2020 - elem }
            if (other != null) {
                println(elem * other)
                return
            }
        }
    }

    fun part2() {
        val input = readLines("day1").map { it.toInt() }
        for (i in 0..input.size - 2) {
            val now1 = input[i]
            for (j in i + 1 until input.size) {
                val now2 = input[j]
                val other = input.find { it == 2020 - now1 - now2 }
                if (other != null) {
                    println(now1 * now2 * other)
                    return
                }
            }
        }
    }
}
