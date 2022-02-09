//Created by Anastasia Drogunova
//Date: 10.01.2022 Time 13:05

package scopes
//Если все открывающиеся скобки - закрываются в этой строке, необходимо вернуть true
//Если есть какая то скобка - которая не имеет скобки закрытия, вернуть false.
//Если есть скобка которая идет не в своем порядке(}{ ]{,
// то есть скобка всегда должна сначала открываться, и только потом иметь закрывающий аналог,
// если есть закрывающая скобка но до этого не было открывающей - нужно выкинуть исключение)

//если нет скобки закрытия - false

fun main() {
    val scopeStr = "({[([])]})"
    val arrStr = scopeStr.toCharArray().asList()

    var myDeq = ArrayDeque(arrStr)


}