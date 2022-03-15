import kotlin.properties.Delegates

class Reactor<T>() {



    abstract inner class Cell<T>{
        abstract var value: T
        var computeCells: MutableList<ComputeCell<T>> = mutableListOf()
    }

    open inner class InputCell<T>(inputValue: T) : Cell<T>(){


        override var value = inputValue
            set(newVal) {
                if(newVal != field){
                    field = newVal
                    for (computeCell in computeCells) {
                        computeCell.update()
                    }
                }
            }

    }

    inner class ComputeCell<T>(vararg elements: InputCell<T>, var computator: (List<T>)->T) : InputCell<T>(computator(elements.map{it.value})){
        val inputs = elements.toList()
        init {
            computeCells.add(this)
        }

        fun update(){
            val newVal = computator(inputs.map { it.value })
            if(value != newVal){
                value = newVal
                //callBack()
            }
        }
    }
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }
}


