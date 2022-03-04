object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {

        val res = source.filterNotNull().flatMap {
            if( it is Collection<Any?>)
                flatten(it)
            else
                listOf(it)
        }
        return res
    }
}
