//Created by Anastasia Drogunova
//Date: 10.01.2022 Time 13:05

package scopes

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

//Если все открывающиеся скобки - закрываются в этой строке, необходимо вернуть true
//Если есть какая то скобка - которая не имеет скобки закрытия, вернуть false.
//Если есть скобка которая идет не в своем порядке(}{ ]{,
// то есть скобка всегда должна сначала открываться, и только потом иметь закрывающий аналог,
// если есть закрывающая скобка но до этого не было открывающей - нужно выкинуть исключение)

//если нет скобки закрытия - false


fun checkScopes(scopeStr: String) : Boolean {

    val scopeMap : HashMap<Char, Char> = hashMapOf('(' to ')', '[' to ']', '{' to '}')
    val stack = Stack<Char>()
    val isEven = scopeStr.length % 2 == 0   // если число скобок нечётно,
                                            // то мы можем сразу сказать,
                                            // что какая-то из скобок не закрывается
    if (isEven) {
        stack.push(scopeStr[0])
        for (index in scopeStr.indices - 0)
        {
            when {
                scopeMap.containsKey(scopeStr[index]) -> stack.push(scopeStr[index])
                scopeMap.containsValue(scopeStr[index]) && scopeMap.get(stack.peek()) == scopeStr[index] -> stack.pop()
                else -> throw IllegalArgumentException("Ошибка последовательности скобок!")
            }
        }
    }
    return (isEven && stack.isEmpty())
}

fun main() {
    val scopeStr_valid1 = "({[([])]})"
    val scopeStr_valid2 = "()(){[[]]()}"
    val scopeStr_invalid = "((({())))"
    val scopeStr_exeption1 = "((}{})"

    println(checkScopes(scopeStr_valid1))
    println(checkScopes(scopeStr_valid2))
    println(checkScopes(scopeStr_invalid))
    try {
        println(checkScopes(scopeStr_exeption1))
    } catch (e: IllegalArgumentException) {
        println("Искплючение бросила строка: scopeStr_exeption1 = \"((}{})\"")
    }
}
