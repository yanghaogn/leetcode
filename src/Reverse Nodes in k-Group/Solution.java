package com.Algorithms.Offer;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;


class ListNode
{
    int val;

    ListNode next;

    ListNode(int x)
    {
        val = x;
        next = null;
    }
}


public class Solution
{
    public void reverse(ListNode head)
    {
        ListNode first = head;
        ListNode second = first.next;
        first.next = null;
        while (second != null)
        {
            ListNode p = second.next;
            second.next = first;
            first = second;
            second = p;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k)
    {
        if (head == null || head.next == null || k <= 1)
        {
            return head;
        }
        ListNode pHead = new ListNode(0);
        ListNode first = null;
        ListNode end = null;
        ListNode p = null;
        ListNode last = pHead;
        for (first = head; first != null; first = p)
        {
            int i = 1;
            for (end = first; end.next != null && i < k; i++ , end = end.next);
            if (i < k)
            {
                last.next = first;
                break;
            }
            p = end.next;
            end.next = null;
            reverse(first);
            last.next = end;
            last = first;
        }
        return pHead.next;
    }
}