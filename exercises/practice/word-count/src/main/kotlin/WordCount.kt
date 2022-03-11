object WordCount {

    fun phrase(phrase: String): Map<String, Int> {

        return phrase.split("[^a-zA-Z0-9']+".toRegex())
            .map{it.trim('\'').lowercase()}
            .filter{it.isNotEmpty()}
            .groupBy { it }
            .map {
                Pair(it.key, it.value.size)
                //or use the key to value syntax:
                //it.key to it.value.size
            }.toMap()
    }

}
