package com.example.asus.quarterofanhourdemo.view.iview;

/**
 * 创建时间  2017/12/11 15:56
 * 创建人    gaozhijie
 * 类描述
 */
public class aaa {
    static class Node {
        Integer data;
        Node next;

        private Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node l = new Node(null, new Node(1,
                new Node(2, new Node(3, new Node(4,
                        new Node(5, new Node(null, null)))))));
        Node curr = l;
        if (revers(l, 5)) {
            while ((curr = curr.next) != null) {
                System.out.println(curr.data);
            }

        }
    }

    public static boolean revers(Node h, int p) {
        if (p < 1) {
            return false;
        }
        Node[] nodes = new Node[p];
        Node curr = h.next;
        for (int i = 0; i < p && curr != null; i++, curr = curr.next) {
            nodes[i] = curr;
        }
        if (curr == null) {
            return false;
        }
        for (int i = p - 1; i > 0; i--) {
            nodes[i].next = nodes[i - 1];
        }
        nodes[0].next = curr;
        h.next = nodes[p - 1];
        return true;
    }

}
