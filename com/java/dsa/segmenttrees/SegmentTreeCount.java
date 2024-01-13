package com.java.dsa.segmenttrees;

public class SegmentTreeCount {
    SegmentTreeNode root;

    SegmentTreeCount(int min, int max) {
        root = new SegmentTreeNode(min, max);
    }

    public void insert(int value) {
        SegmentTreeNode temp = root;
        root.count++;
        while(temp.start != temp.end) {
            int mid = temp.start + (temp.end - temp.start) / 2;
            if(value <= mid) {
                if(temp.left == null)
                    temp.left = new SegmentTreeNode(temp.start, mid);
                temp = temp.left;
            } else {
                if(temp.right == null)
                    temp.right = new SegmentTreeNode(mid+1, temp.end);
                temp = temp.right;
            }
            temp.count++;
        }
    }

    public void update(int start, int end, int count) {
        updateUtil(root, start, end, count);
    }

    private void updateUtil(SegmentTreeNode temp, int start, int end, int count) {
        if(temp == null)
            return;
        if(temp.start == temp.end) {
            temp.count += count;
            return;
        }
        int mid = temp.start + (temp.end - temp.start) / 2;
        if(end <= mid)
            updateUtil(temp.left, start, end, count);
        else if(start > mid)
            updateUtil(temp.right, start, end, count);
        else {
            updateUtil(temp.left, start, mid, count);
            updateUtil(temp.right, mid+1, end, count);
        }
        temp.count = (temp.left != null? temp.left.count: 0) + (temp.right != null? temp.right.count: 0);
    }


    public int query(int start, int end) {
        return queryUtil(root, start, end);
    }

    private int queryUtil(SegmentTreeNode temp, int start, int end) {
        if(temp == null)
            return 0;
        if(temp.start == start && temp.end == end)
            return temp.count;
        int mid = temp.start + (temp.end - temp.start) / 2;
        if(end <= mid) // completely in left
            return queryUtil(temp.left, start, end);
        else if(start > mid) // completely in right
            return queryUtil(temp.right, start, end);
        else // spanning in both
            return queryUtil(temp.left, start, mid) + queryUtil(temp.right, mid+1, end);
    }
}