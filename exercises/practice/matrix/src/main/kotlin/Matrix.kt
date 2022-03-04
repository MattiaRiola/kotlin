


class Matrix(private val matrixAsString: String) {

    private var matrix: MutableList<MutableList<Int>> = mutableListOf()

    init {
        matrix = matrixAsString.lines().asSequence().map {
                it.trim() //clean spaces
            }
            .map {
                it.split(" +".toRegex())
            }.map { row ->
                row.asSequence().map {
                    it.toInt()
                }.toMutableList()

            }.toMutableList()
        println(matrix);


    }
    fun column(colNr: Int): List<Int> {
        return matrix.map{
            it[colNr-1]
        }.toList()
    }

    fun row(rowNr: Int): List<Int> {

        return  matrix[rowNr-1]
    }

    fun coordinate(rowNr: Int, colNr: Int): Int {
        return matrix[colNr][rowNr]
    }
}
