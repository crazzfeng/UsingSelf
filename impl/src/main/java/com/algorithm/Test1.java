package com.algorithm;

/**
 * @author yufeng li
 * @title: Test1
 * @description:
 * @date 2019/8/15 16:44
 */
public class Test1 {

    public static void main(String[] args) {
      /*  ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        l11.setNext(l12);
        l1.setNext(l11);

        ListNode l2 = new ListNode(1);*/
       /* ListNode l21 = new ListNode(8);
        ListNode l22 = new ListNode(3);
        l21.setNext(l22);
        l2.setNext(l21);
        */
       //ListNode res = Test1.addTwoNumbers(l1,l2);
        System.err.println("123".substring(3,3));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode result1 = result;
        while(l1 != null || l2 != null){

            int res = (l1==null?0:l1.val) + (l2==null?0:l2.val) + result.val;
            int num= res/10;
            int x = res%10;
            result.val = x;
            ListNode listNode = new ListNode(num);
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
            if ((l1 !=null || l2 != null) || num != 0){
                result.next = listNode;
                result = listNode;
            }
        }

        return result1;
    }


   static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x ){
            this.val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int x) {
            this.val = x;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
