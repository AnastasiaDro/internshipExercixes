//Created by Anastasia Drogunova
//Date: 10.01.2022 Time: 13:06

package stringPackage
import java.lang.Character.getNumericValue

/**Класс для упаковки-распаковки строк*/

class ZipManager : IPackUnpack {

    /** Упаковка строки:
    Считается число идущих подряд одинаковых символов и создаётся строка,
    где пишется это число и повторяющийся символ
    --Пример: "AABCCC -> packing -> 2AB3C"
    При этом числа в первоначальной строке при упаковке отбрасываются:
    --Пример: "8Y__c5c -> packing -> Y__2c"
    */

    override fun packString(src: String): String {
    //    if (src.isEmpty()) return ""

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

    /** Распаковка строки:
    Из упакованной описанным выше методом строки извлекается
    первоначальная строка: числа воспринимаются как количество символов, идущих за числом
    символы без числа перед ними печатаются в единственном экземпляре
    --Пример: "2i4ug" -> unpacking -> "iiuuuug"
     */
    override fun unPackString(src: String): String {
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

    //Присоединить последовательность букв к строке-результатов
    private fun appendLetterPool(sb: StringBuilder, num: Int, c: Char) {
        for (index in 1 until num)
            sb.append(c)
    }

    //Пропустить числа в строке
    private fun moveIndexThroughDigits(src: String, index: Int): Int {
        var shiftedIndex = index
        while (shiftedIndex < src.length && src[shiftedIndex].isDigit())
            shiftedIndex++
        return shiftedIndex
    }

    //Присоединить букву к строке-результату
    private fun appendLetter(count: Int, sb: StringBuilder, cPrev: Char) {
        if (count > 1)
            sb.append(count)
        sb.append(cPrev)
    }

}