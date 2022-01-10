package stringPackage

import java.lang.Character.getNumericValue

//Присоединить букву
private fun appendLetter(count: Int, sb: StringBuilder, cPrev: Char) {
    if (count > 1)
        sb.append(count)
    sb.append(cPrev)
}

//Присоединить последовательность букв
private fun appendLetterPool(sb: StringBuilder, num: Int, c: Char) {
    for (index in 1 until num)
        sb.append(c)
}

//Пропустить числа
private fun moveIndexThroughDigits(src: String, index: Int): Int {
    var shiftedIndex = index
    while (shiftedIndex < src.length && src[shiftedIndex].isDigit())
        shiftedIndex++
    return shiftedIndex
}

//Функция упаковки
fun packString(src: String = ""): String {
    if (src.isEmpty()) return ""

    var count = 1
    var index = 0
    index = moveIndexThroughDigits(src, index)
    if (index >= src.length)
        return ""
    index++
    var cPrev = src[index - 1]
    val sb = StringBuilder(src.length)
    while (index < src.length) {
        index = moveIndexThroughDigits(src, index)
        if (index >= src.length)
            break
        if (src[index] == cPrev) count++
        else {
            appendLetter(count, sb, cPrev)
            count = 1
            cPrev = src[index]
        }
        index++
    }
    if (count > 1)
        sb.append(count)
    sb.append(cPrev)
    return (sb.toString())
}

//Функция распаковки
fun unPackString(src: String): String {
    if (src.isEmpty()) return ""

    var num: Int
    var inc = 0
    val sb = StringBuilder()

    for (index in 0 until src.length - inc) {
        if (src[index].isDigit() && src.length > index + 1) {
            num = getNumericValue(src[index])
            appendLetterPool(sb, num, src[index + 1])
            inc += num
        } else {
            sb.append(src[index])
        }
    }
    return (sb.toString())
}

fun main() {

    /* я решила отбрасывать и не упаковывать числа из изначальной строки, чтобы при распаковке
       не менялись данные, то есть
       не получилось ситуации 8ABC -> packing-unpacking -> AAAAAAAABC

       в связи с этим пришлось обработать кейсы, когда числа в начале, середине или конце строки
    */

//Тестовые кейсы
    val cases = arrayOf("))81))AA", "AAAABCCC", "", "ZYXXXXXX___", "8ABC", "VVVG8", "986")
//Печать тестовых кейсов
    print("strings          : ")
    for (i in cases) print("${i}, ")
    println()
//Упаковка
    val packedArr = Array(7, { i -> packString(cases[i]) })
//Печать упакованных строк
    print("After packing    : ")
    for (i in packedArr) print("${i},    ")
    println()
//Распаковка
    val unPackedArr = Array(7, { i -> unPackString(packedArr[i]) })
//Печать распакованных строк
    print("After unPacking  : ")
    for (i in unPackedArr) print("${i},  ")
    println()
}
