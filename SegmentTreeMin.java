public class SegmentTreeMin {
    int[] tree;
    int n;

    SegmentTreeMin(int[] A) {
        tree = new int[A.length * 2 + 2];
        n = A.length - 1;
        buildTree(A, 0, n, 0);
    }

    private int buildTree(int[] A, int start, int end, int index) {
        if(start == end) //single length segment
            tree[index] = A[start];
        else {
            int mid = start + (end - start) / 2;
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            tree[index] = Math.min(buildTree(A, start, mid, left), buildTree(A, mid + 1, end, right));
        }
        return tree[index];
    }

    public void update(int position, int value) {
        updateUtil(0, n, position, value, 0);
    }

    private void updateUtil(int start, int end, int position, int value, int index) {
        if(position < start || position > end)
            return;
        else if(start == end && end == position) {
            tree[index] = value;
            return;
        }

        int mid = start + (end - start) / 2;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(position <= mid)
            updateUtil(start, mid, position, value, left);
        else 
            updateUtil(mid+1, end, position, value, right);
        
        tree[index] = Math.min(tree[left], tree[right]);
    }

    public int queryMin(int start, int end) {
        return queryMinUtil(0, n, start, end, 0);
    }

    private int queryMinUtil(int start, int end, int qStart, int qEnd, int index) {
        if(qStart <= start && qEnd >= end)
            return tree[index];
        else if(qStart > end || qEnd < start)
            return Integer.MAX_VALUE;
        
        int mid = start + (end - start) / 2;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        return Math.min(queryMinUtil(start, mid, qStart, qEnd, left), queryMinUtil(mid+1, end, qStart, qEnd, right));
    }

    public int queryMax(int start, int end) {
        return queryMaxUtil(0, n, start, end, 0);
    }

    private int queryMaxUtil(int start, int end, int qStart, int qEnd, int index) {
        if(qStart <= start && qEnd >= end)
            return tree[index];
        else if(qStart > end || qEnd < start)
            return Integer.MAX_VALUE;
        
        int mid = start + (end - start) / 2;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        return Math.max(queryMaxUtil(start, mid, qStart, qEnd, left), queryMaxUtil(mid+1, end, qStart, qEnd, right));
    }
}