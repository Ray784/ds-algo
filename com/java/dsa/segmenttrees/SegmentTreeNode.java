package com.java.dsa.segmenttrees;

class SegmentTreeNode {
    int start;
    int end;
    SegmentTreeNode left;
    SegmentTreeNode right;
    int count;
    SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.count = 0;
    }
}