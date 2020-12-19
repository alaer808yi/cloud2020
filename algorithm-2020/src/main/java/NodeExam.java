import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @ Author     ：jane.
 * @ Date       ：Created in 23:43 2020/6/16
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class NodeExam {
    public static void main(String args[]) {
//        ScheduledThreadPoolExecutor
        HashMap map = new HashMap();
        ConcurrentHashMap map1 = new ConcurrentHashMap();
        // pool init
//        Node node3 = new Node("3", null, null);
//        Node node2 = new Node("2", null, node3);
//        Node head = new Node("1", null, node2);
//        node2.pre = head;
//        node3.pre = node2;
//        node3.next = head;
//        head.pre = node3;
        // cool init
        Node headAfterHead = new Node(1, null, null);
        insertNodeAfterHead(headAfterHead,2);
        insertNodeAfterHead(headAfterHead,3);


        Node headAfterTail = new Node(1, null, null);



    }

    // 头插法
    public static void insertNodeAfterHead(Node head, int data) {
        if (head == null) {
            return;
        }
        Node insertNode = new Node(data, null, null);
        // only one head
        if (head.next == null) {
            head.next = insertNode;
            head.pre = insertNode;
            insertNode.next = head;
            insertNode.pre = head;
        }else{
            Node afterNode = head.next;
            head.next = insertNode;
            insertNode.next = afterNode;
            afterNode.pre = insertNode;
            insertNode.pre = head;
        }
    }


    static class Node {
        private int data;
        private Node pre;
        private Node next;

        Node(int data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }
}
