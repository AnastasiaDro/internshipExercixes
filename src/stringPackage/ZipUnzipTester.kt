//Created by Anastasia Drogunova
//Date: 10.01.2022 Time: 16:08

package stringPackage

import kotlin.math.exp

class ZipUnzipTester(val zipManager: ZipManager) {
    //Тестовые кейсы
    val cases = arrayOf("))81))AA", "AAAABCCC", "", "ZYXXXXXX___", "8ABC", "VVVG8", "986")
    init {
        printStrings("Cases:  ", cases)
    }
    //Ожидаемые результаты тестов
    val resZip = arrayOf("4)2A", "4AB3C", "", "ZY6X3_", "ABC", "3VG", "")
    val resUnzip = arrayOf("))))AA", "AAAABCCC", "", "ZYXXXXXX___", "ABC", "VVVG", "")
    //Переменные для записи результатов тестов
    var zipped = arrayOf<String>()
    var unzipped = arrayOf<String>()

    fun testZip(){
        zipped = Array(cases.size, { i -> zipManager.packString(cases[i]) })
        test("ZIPPING TEST", resZip, zipped)
    }

    fun testUnzip() {
        unzipped = Array(zipped.size, {i -> zipManager.unPackString(zipped[i])})
        test("UNZIPPING TEST", resUnzip, unzipped)
    }

    private fun printStrings(header: String, arr: Array<String>) {
        print("${header} :  ")
        for (i in arr) print("${i}, ")
        println()
    }

    private fun test(name: String, expected: Array<String>, result: Array<String>){
        println("-------${name}------")
        printStrings("Expected", expected)
        printStrings("Result  ", result)
        if (result.contentEquals(expected)) println("-------SUCCESS-------") else println("-------FAILURE-------")
        println()
    }

}