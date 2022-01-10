//Created by Anastasia Drogunova
//Date: 10.01.2022 Time: 13:04

package stringPackage

/** Содержит функции для упаковки-распаковки строк
    Наследуемые PackUnpackManager-
    */

interface IPackUnpack {

    fun packString(src: String): String

    fun unPackString(src: String): String
}