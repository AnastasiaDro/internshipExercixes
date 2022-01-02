package stringPackage

import java.lang.Character.getNumericValue

//JVM JIT compiler will inline small methods on its own
fun appendLetter(count : Int, sb : StringBuilder, cPrev : Char) {
    if (count > 1)
        sb.append(count)
    sb.append(cPrev)
}

fun appendLetterPool(sb : StringBuilder, num : Int, c : Char) {
    for (j in 1..num - 1)
        sb.append(c)
}

fun packString(src : String = "") : String {
    if (src.isEmpty()) return ""

    var count = 1
    var j = 1
    var cPrev = src[j-1]
    val sb   = StringBuilder(src.length)
    while (j < src.length) {
        while (src[j].isDigit()) ///я хотела, чтобы
            j++
        //if (src[j - 1].isDigit()) j++ //else cPrev = src[j - 1]
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

fun unPackString1(src: String) : String
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

// for cases with 10 and more repetitons
//fun unpackString2(src : String) : String
//{
//    var num : Int
//    val res = StringBuilder()
//    val numberStr = StringBuilder("")
//    var j = 0
//    var start : Int
//    while (j < src.length)
//    {
//        start = j
//        while (j < src.length && src[j].isDigit())
//            numberStr.append(src[j++])
//        if (j < src.length) {
//            num = if (j != start) numberStr.toString().toInt() else 1
//            numberStr.clear()
//            appendLetterPool(res, num, src[j])
//        }
//        j++
//    }
//    return(res.toString())
//}


fun main() {

    // я решила обрезать числа в изначальной строке, чтобы при распаковке

    val s0 = "))81))AA"
    val s1 = "AAAABCCC"
    val s2 = ""
    val s3 = "ZYXXXXXX___"
    val s4 = "8ABC"
    println("""Strings:
        s1 ${s1}
        s2 ${s2} //empty string
        s3 ${s3}
        s4 ${s4}
    """.trimIndent())



//    val res1 = packString(s1)
//    val res2 = packString(s2)
   // val res3 = packString(s3)
    val res3 = packString(s3)
    val res0 = packString(s0)
  //  println("""After packing
//        s1 -> ${res1}
//        s2 -> ${res2}
//        s3 -> ${res3}
//        s4 -> ${res4}
//    """.trimIndent())
    println("s4 = ${res3}")
    println("s0 = ${res0}")
  //  println("""After unpacking
//        s1 -> ${unPackString1(res1)}
//        s2 -> ${unPackString1(res2)}
//        s3 -> ${unPackString1(res3)}
//        s4 -> ${unPackString1(res4)}
//    """.trimIndent())
}

