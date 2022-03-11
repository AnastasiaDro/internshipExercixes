//Created by Main
//Date: 10.03.2022 Time: 19:07

package linkedlist.first

fun main() {
    val list = MyLinkedList()
    list.addAtTail(4)
    list.addAtTail(6)
//
//    println(list.get(2))
//    println(list.get(1))
//    println(list.get(0))

//    println("add at index")
//    list.addAtIndex(1, 5)
//    println(list.get(0))
//    println(list.get(1))
//    println(list.get(2))
//
//    println("add at index tail")
//    list.addAtIndex(3, 7)
//    println(list.get(0))
//    println(list.get(1))
//    println(list.get(2))
//    println(list.get(3))
//
//    println("add at index invalid")
//    list.addAtIndex(5, 7)
//    println(list.get(0))
//    println(list.get(1))
//    println(list.get(2))
//    println(list.get(3))
//    println(list.get(4))
//    println(list.get(5))

    println("add at index head")
    list.addAtIndex(0, 3)
    println(list.get(0))
    println(list.get(1))
    println(list.get(2))
//    println(list.get(3))
//    println(list.get(4))
}
