//Created by Anastasia Drogunova
//Date: 10.01.2022 Time 13:05

package stringPackage

fun main() {
    val packManager = PackUnpackManager()

    //Тестовые кейсы
    val cases = arrayOf("))81))AA", "AAAABCCC", "", "ZYXXXXXX___", "8ABC", "VVVG8", "986")
    //Печать тестовых кейсов
    print("strings          : ")
    for (i in cases) print("${i}, ")
    println()
    //Упаковка
    val packedArr = Array(7, { i -> packManager.packString(cases[i]) })
    //Печать упакованных строк
    print("After packing    : ")
    for (i in packedArr) print("${i},    ")
    println()
    //Распаковка
    val unPackedArr = Array(7, { i -> packManager.unPackString(packedArr[i]) })
    //Печать распакованных строк
    print("After unPacking  : ")
    for (i in unPackedArr) print("${i},  ")
    println()
}