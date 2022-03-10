//Created by MyLinkedList
//Date: 10.03.2022 Time: 19:08

package linkedlist.first

class MyLinkedList {
    private class Elem(mValue: Int) {
        var value = mValue
        var next : Elem? = null
    }

    private var startElem : Elem? = null

    fun get(index: Int): Int {
        var pointer: Elem? = startElem
       if (pointer != null) {
           for (i in 0..index) {
               if (pointer!!.next != null) {
                   pointer = pointer.next
               } else {
                   break
               }
           }
       }
        if (pointer != null) return (pointer.value) else return (-1)
    }

    fun addAtHead(mValue: Int) {
        val newElem = Elem(mValue)
        if (startElem == null)
            startElem = newElem
        else {
            newElem.next = Elem(startElem!!.value)
            newElem.next = startElem!!.next
            startElem = newElem
        }
    }

    fun addAtTail(mValue: Int) {
        var pointer: Elem
        if (startElem == null)
            startElem = Elem(mValue)
        else {
            pointer = startElem!!
            while (pointer.next != null) {
                pointer = pointer.next!!
            }
            pointer.next = Elem(mValue)
        }
    }

    fun addAtIndex(index: Int, mValue: Int) {

    }

    fun deleteAtIndex(index: Int) {

    }

}
