//Created by Solution
//Date: 22.03.2022 Time: 10:31

package linkedlist.second

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null)
            return false
        var slow = head
        var fast = head

        while (slow != null && fast != null) {
            slow = slow.next
            fast = fast.next?.next
            if (slow == fast)
                return true
        }
        return false
    }
}