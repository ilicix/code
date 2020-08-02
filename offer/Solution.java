package offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            }
            map.put(nums[i], i);
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int val = matrix[mid / cols][mid % cols];
            if (val == target) {
                return true;
            } else if (val < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length - 1;
        int i = 0;
        int j = columns;
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public String replaceSpace(String s) {
        if (s.length() == 0 || s == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                builder.append(s.charAt(i));
            } else {
                builder.append('%');
                builder.append('2');
                builder.append('0');
            }
        }
        return builder.toString();
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        int[] data = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            int data_item = stack.pop();
            data[i] = data_item;
            i++;
        }
        return data;
    }

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    public int numWays(int n) {
        if (n < 1) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    public int minArray(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;
        int mid = 0;
        while (start < end) {
            mid = (start + end) >> 1;
            if (numbers[mid] < numbers[end]) {
                end = mid;
            } else if (numbers[mid] > numbers[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }
        return numbers[start];
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 7];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        if (n <= 6) {
            return dp[n];
        }
        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 3] * 3;
        }
        return dp[n];
    }

    public double myPow(double x, int n) {
        if (x == 0 || n == 0) {
            return 1.0;
        }
        if (n == 0) {
            return 1.0;
        }
        long n1 = n;
        if (n < 0) {
            n1 = -n1;
            x = 1 / x;
        }
        double res = 1;
        while (n1 != 0) {
            if (n1 % 2 == 1) {
                res = res * x;
            }
            x = x * x;
            n1 /= 2;
        }
        return res;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode p = head;
        while (p != null) {
            if (p.next.val == val) {
                break;
            }
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
        }
        return head;
    }

    public int[] exchange(int[] nums) {
        if (nums == null) {
            return null;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode p = head;
        ListNode newHead = null;
        while (p != null) {
            ListNode next = p.next;
            if (next == null) {
                newHead = p;
            }
            p.next = pre;
            pre = p;
            p = next;
        }
        return newHead;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}

class BuildTree {
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        TreeNode root = new TreeNode(pre[pre_root]);
        int i = map.get(pre[pre_root]);
        root.left = recur(pre_root + 1, in_left, i - 1);
        root.right = recur(pre_root + i - in_left + 1, i + 1, in_right);
        return root;
    }
}

class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int size;

    public CQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.size = 0;
    }

    public void appendTail(int value) {
        stack1.push(value);
        this.size++;
    }

    public int deleteHead() {
        if (!stack2.empty()) {
            this.size--;
            return stack2.pop();
        }
        if (stack1.empty()) {
            return -1;
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        this.size--;
        return stack2.pop();
    }
}

class Matric_exist {
    private char[][] board;
    private char[] word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word.toCharArray();
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                if (dfs(i, j, rows, columns, 0)) {
                    return true;
                }
            }
        return false;
    }

    private boolean dfs(int row, int column, int rows, int columns, int k) {
        if (row >= rows || row < 0 || column >= columns || column < 0) {
            return false;
        }
        if (board[row][column] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        char temp = board[row][column];
        board[row][column] = '#';
        boolean flag = dfs(row + 1, column, rows, columns, k + 1) || dfs(row, column + 1, rows, columns, k + 1)
                || dfs(row - 1, column, rows, columns, k + 1) || dfs(row, column - 1, rows, columns, k + 1);
        board[row][column] = temp;
        return flag;
    }
}

class movingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        return get_movingcount(m, n, k, 0, 0, flag);
    }

    private int get_movingcount(int m, int n, int k, int i, int j, boolean[][] flag) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (get_sum(i) + get_sum(j) > k) {
            return 0;
        }
        if (flag[i][j] == true) {
            return 0;
        }
        flag[i][j] = true;
        return 1 + get_movingcount(m, n, k, i + 1, j, flag) + get_movingcount(m, n, k, i, j + 1, flag)
                + get_movingcount(m, n, k, i - 1, j, flag) + get_movingcount(m, n, k, i, j - 1, flag);
    }

    private int get_sum(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}

class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}

class MirrorTree {
    public TreeNode mirrorTree_recur(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree_recur(root.right);
        root.right = mirrorTree_recur(temp);
        return root;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}

class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return recur(a.left, b.right) && recur(a.right, b.left);
    }
}