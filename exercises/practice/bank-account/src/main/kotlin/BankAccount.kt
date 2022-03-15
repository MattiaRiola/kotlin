class BankAccount {
    private var isCountOpen = true
    private var lock = Any()

    var balance :Long = 0
        get(){
            synchronized(lock) {
                if (isCountOpen)
                    return field
                else
                    throw IllegalStateException("reading a closed count")
            }
        }
        private set

    fun adjustBalance(amount: Long){
        synchronized(lock) {
            if (isCountOpen)
                balance += amount
            else
                throw IllegalStateException("operations on closed count")
        }
    }

    fun close() {
        synchronized(lock) {
            isCountOpen = false
        }
    }
}
