package com.go.leet_code.tl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import java.util.Objects;
import java.util.Stack;

/**
 * @author go
 * @since 2022-03-14 22:58
 **/
public class ReverseNodeList {

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    static class Node {
        Integer data;
        Node next;

        public Node(Integer data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = createTestNode();
        System.out.println("head = " + head);
        Node reverse1 = reverseByStack(head);
        System.out.println("reverse1 = " + reverse1);
    }

    /**
     * reverse by stack struct
     *
     * @param source
     * @return
     */
    public static Node reverseByStack(Node source) {
        Stack<Integer> stack = new Stack<>();
        Node current = source;
        while (!Objects.isNull(current)) {
            stack.push(current.getData());
            current = current.getNext();
        }
        Node head = new Node();
        if (!Objects.isNull(stack.peek())) {
            head = new Node(stack.pop(), null);
        }
        Node cur = head;
        while (stack.size() > 0) {
            Node next = new Node(stack.pop());
            cur.setNext(next);
            cur = next;
        }
        return head;
    }

    public static Node createTestNode() {
        return new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
    }

}
