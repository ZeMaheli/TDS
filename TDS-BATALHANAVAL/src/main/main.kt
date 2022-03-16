package main

const val rowSize = 10
const val columnSize = 10

fun main() {
    val board = Board()
    board.insert(0,0)
    board.insert(0,1)
    board.insert(0,2)
    board.insert(0,3)
    board.draw()

}

enum class Row(val letter: Char) {
    A(letter = 'a'),
    B(letter = 'b'),
    C(letter = 'c'),
    D(letter = 'd'),
    E(letter = 'e'),
    F(letter = 'f'),
    G(letter = 'g'),
    H(letter = 'h'),
    I(letter = 'i'),
    J(letter = 'j')
}

enum class Column(val number: Int) {
    One(number = 1),
    Two(number = 2),
    Three(number = 3),
    Four(number = 4),
    Five(number = 5),
    Six(number = 6),
    Seven(number = 7),
    Eight(number = 8),
    Nine(number = 9),
    Ten(number = 10),
}

data class Square(val column: Column, val row: Row) {
}

class Board {
    private val board: MutableList<MutableList<String>> = MutableList(rowSize){ MutableList(columnSize){"."}}
    private val indexToBoatMap: HashMap<String, Boat> = HashMap(5)

    private fun drawNumbers() {
        print("     ")
        for (index in Column.values()) {
            print("${index.ordinal}  ")
        }
        println("  ")
        println("    ------------------------------")
    }

    private fun drawLetters(index: Int) {
        val letter = Row.values()[index]
        print("$letter |  ")
    }

    fun draw() {
        drawNumbers()
        for(index in board.indices){
            drawLetters(index)
            for(index2 in board[index].indices){
                val value = board[index][index2]
                print("$value  ")
            }
            print("|")
            println()
        }
        println("    ------------------------------")
    }
    fun insert(x: Int, y: Int){
        this.board[x][y] = "#"
    }
}

enum class Boat(size: Int) {
    OneSquare(1),
    TwoSquare(2),
    ThreeSquare(3),
    FourSquare(4),
    TShaped(5),
}


