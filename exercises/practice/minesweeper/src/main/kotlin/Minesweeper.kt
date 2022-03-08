data class MinesweeperBoard(val input: List<String>) {
//    private var output: MutableList<String> = input.toMutableList()


    fun withNumbers(): List<String> {
        val res = input.mapIndexed{ y, row ->
            val rowRes = row.mapIndexed { x, slot ->
                if( slot == '*'){
                    '*'
                }
                else {
                    calcCloseBombs(x, y)
                }
            }.joinToString(separator = "")
            rowRes
        }

        return res

    }

    private fun calcCloseBombs(x: Int, y: Int): Char {
        var count = 0
        val xMin = maxOf(0, x - 1)
        val yMin = maxOf(0, y - 1)
        val xMax = minOf(x + 1, input[y].lastIndex)
        val yMax = minOf(y + 1, input.lastIndex)
        for (i in yMin..yMax)
            for (j in xMin..xMax)
                if (input[i][j] == '*')
                    count++
        return if (count == 0)
            ' '
        else
            count.toString()[0]
    }


}
