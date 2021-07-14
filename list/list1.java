package list;

// Leetcode
// Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/submissions/

public class list1 {
    static ListNode answer;
    public list1(){
        answer = null;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(4)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        
        ListNode l1Node = l1;
        ListNode l2Node = l2;

        int round = 0;
        while(l1Node != null || l2Node != null){
            int value = round;
            
            if(l1Node != null){
                value += l1Node.val;
                l1Node = l1Node.next;
            } 
            if(l2Node != null){
                value += l2Node.val;
                l2Node = l2Node.next;
            } 

            if(value >= 10){
                round = 1;
                value = value % 10;
            } else{
                round = 0;
            }

            insertNode(value);
        }

        if(round == 1) insertNode(1);

    }

    static void insertNode(int value){
        ListNode listNode = new ListNode(value);
        if(answer == null){
            answer = listNode;
        } else{
            ListNode tempNode = answer;
            while(tempNode.next != null){
                tempNode = tempNode.next;
            }

            tempNode.next = listNode;
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
