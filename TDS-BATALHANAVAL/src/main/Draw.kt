package main

data class Square(val column: Column, val row: Row){
    fun x() = row.number
    fun y() = column.number
}

enum class Column(val letter: Char, val number: Int) {
    A(letter = 'a', number = 0),
    B(letter = 'b', number = 1),
    C(letter = 'c', number = 2),
    D(letter = 'd', number = 3),
    E(letter = 'e', number = 4),
    F(letter = 'f', number = 5),
    G(letter = 'g', number = 6),
    H(letter = 'h', number = 7),
    I(letter = 'i', number = 8),
    J(letter = 'j', number = 9);

    override fun toString() = "$letter"
}

enum class Row(val number: Int) {
    One(number = 0),
    Two(number = 1),
    Three(number = 2),
    Four(number = 3),
    Five(number = 4),
    Six(number = 5),
    Seven(number = 6),
    Eight(number = 7),
    Nine(number = 8),
    Ten(number = 9);

    override fun toString() = "$number"
}

abstract class Draw {
    fun drawNumbers() {
        print("     ")
        for (index in Column.values()) {
            print("${index.ordinal}  ")
        }
        println("  ")
        println("    ------------------------------")
    }

    fun drawLetters(index: Int) {
        val letter = Row.values()[index]
        print("$letter |  ")
    }

    abstract fun draw()
}

fun Char.toColumn(): Column{
    require(this.isInColumn()){println("Wrong char")}
    val index = this.lowercaseChar() - 'a'
    return Column.values()[index]
}

fun Int.toRow(): Row{
    require(this.isInRow()){println("Wrong number")}
    return Row.values()[this - 1]
}

fun Char.isInColumn() = this in 'a'..'j'

fun Int.isInRow() = this in 1..10