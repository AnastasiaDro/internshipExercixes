package stringPackage


fun main() {

    /* я решила отбрасывать и не упаковывать числа из изначальной строки, чтобы при распаковке
       не менялись данные, то есть
       не получилось ситуации 8ABC -> packing-unpacking -> AAAAAAAABC

       в связи с этим пришлось обработать кейсы, когда числа в начале, середине или конце строки
    */

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
