package stringPackage

import java.lang.Character.getNumericValue

//Присоединить букву
fun appendLetter(count : Int, sb : StringBuilder, cPrev : Char) {
    if (count > 1)
        sb.append(count)
    sb.append(cPrev)
}

//Присоединить последовательность букв
fun appendLetterPool(sb : StringBuilder, num : Int, c : Char) {
    for (j in 1..num - 1)
        sb.append(c)
}

//Пропустить числа
fun moveIndexThroughDigits(src : String, j : Int) : Int
{
    var i = j
    while (i < src.length && src[i].isDigit())
        i++
    return i
}

//Функция упаковки
fun packString(src : String = "") : String {
    if (src.isEmpty()) return ""

    var count = 1
    var j = 0
    j = moveIndexThroughDigits(src, j)
    if (j >= src.length)
        return ""
    j++
    var cPrev = src[j-1]
    val sb   = StringBuilder(src.length)
    while (j < src.length) {
        j = moveIndexThroughDigits(src, j)
        if (j >= src.length)
            break
        if (src[j] == cPrev) count++
        else {
            appendLetter(count, sb, cPrev)
            count = 1
            cPrev = src[j]
        }
        j++
    }
    if (count > 1)
        sb.append(count)
    sb.append(cPrev)
    return (sb.toString())
}

//Функция распаковки
fun unPackString(src: String) : String
{
    if (src.isEmpty()) return ""

    var num : Int
    var inc = 0
    val sb = StringBuilder()

    for (i in 0 until src.length - inc) {
        if (src[i].isDigit() && src.length > i + 1)
        {
            num = getNumericValue(src[i])
            appendLetterPool(sb, num, src[i + 1])
            inc += num
        } else {
            sb.append(src[i])
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
    val s0 = "))81))AA"
    val s1 = "AAAABCCC"
    val s2 = ""
    val s3 = "ZYXXXXXX___"
    val s4 = "8ABC"
    val s5 = "VVVG8"
    val s6 = "986"

    //Распечатка тестовых кейсов
    println("""Strings:
        s0 -> ${s0}
        s1 -> ${s1}
        s2 -> ${s2} //empty string
        s3 -> ${s3}
        s4 -> ${s4}
        s5 -> ${s5}
        s6 -> ${s6}
    """.trimIndent())

    //Упаковка
    val res0 = packString(s0)
    val res1 = packString(s1)
    val res2 = packString(s2)
    val res3 = packString(s3)
    val res4 = packString(s4)
    val res5 = packString(s5)
    val res6 = packString(s6)

    //Распечатка упакованных строк
    println("""After packing
        s0 -> ${res0}
        s1 -> ${res1}
        s2 -> ${res2}
        s3 -> ${res3}
        s4 -> ${res4}
        s5 -> ${res5}
        s6 -> ${res6}
    """.trimIndent())

    //Распаковка и печать
    println("""After unpacking
        s0 -> ${unPackString(res0)}
        s1 -> ${unPackString(res1)}
        s2 -> ${unPackString(res2)}
        s3 -> ${unPackString(res3)}
        s4 -> ${unPackString(res4)}
        s5 -> ${unPackString(res5)}
        s6 -> ${unPackString(res6)}
    """.trimIndent())
}

