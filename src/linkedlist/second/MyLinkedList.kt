//Created by MyLinkedList
//Date: 10.03.2022 Time: 19:08

package linkedlist.second

class MyLinkedList {

    private class Elem(mValue: Int) {
        var value = mValue
        var next: Elem? = null
    }

    private var startElem: Elem? = null

    fun get(index: Int): Int {
        val pointer: Elem? = findElem(index)
        if (pointer != null) return pointer.value else return -1
    }

    fun addAtHead(mValue: Int) {
        val newElem = Elem(mValue)
        if (startElem == null)
            startElem = newElem
        else {
            newElem.next = startElem
            startElem = newElem
        }
    }

    fun addAtTail(mValue: Int) {
        var pointer: Elem
        if (startElem != null) {
            pointer = startElem!!
            while (pointer.next != null) {
                pointer = pointer.next!!
            }
            pointer.next = Elem(mValue)
        } else {
            startElem = Elem(mValue)
        }
    }

    private fun findElem(index: Int): Elem? {
        var i = 0
        var pointer: Elem? = null
        if (index >= 0) {
            pointer = startElem
            while (i < index) {
                pointer = pointer?.next
                i++
            }
        }
        return pointer
    }

    fun addAtIndex(index: Int, mValue: Int) {
        val prev = findElem(index - 1)
        if (prev != null ) {
            var next: Elem? = null
            next = prev.next
            prev.next = Elem(mValue)
            prev.next?.next = next
        } else {
           if (index == 0)
               addAtHead(mValue)
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index == 0)
            startElem = startElem?.next
        else {
            val prev = findElem(index - 1)
            prev?.next = prev?.next?.next
        }
    }
}
