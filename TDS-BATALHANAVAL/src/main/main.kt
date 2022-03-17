package main

const val rowSize = 10
const val columnSize = 10

fun main() {
    val board = Board()
    val col = 'h'.toColumn()
    val row = 1.toRow()
    val square = Square(col,row)
    board.insert(square, BoatType.FourSquare)
    board.draw()
}

class Board(/*val player: Player*/) : Draw() {
    private val board: MutableList<MutableList<String>> = MutableList(rowSize){ MutableList(columnSize){"."}}
    private val indexToBoatMap: HashMap<BoatType,List<Square>> = HashMap(5)

    override fun draw() {
        drawNumbers()
        for(index in board.indices){
            drawLetters(index = index)
            for(index2 in board[index].indices){
                val value = board[index][index2]
                print("$value  ")
            }
            print("|")
            println()
        }
        println("    ------------------------------")
    }
    fun insert(square: Square, boat: BoatType){
        this.board[square.x()][square.y()] = "#"
        indexToBoatMap[boat] = listOf(square)
    }
}

enum class BoatType(private val size: Int) {
    OneSquare(1),
    TwoSquare(2),
    ThreeSquare(3),
    FourSquare(4),
    TShaped(5);

    fun getBoatType() = this.size
}


