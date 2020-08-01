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
