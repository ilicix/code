import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            ListNode newNode = new ListNode(val % 10);
            p.next = newNode;
            p = p.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carry = val / 10;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            p.next = newNode;
        }
        return dummy.next;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] data = s.toCharArray();
        int max = 0;
        int i = 0;
        for (int j = 0; j < data.length; j++) {
            if (map.containsKey(data[j])) {
                i = Math.max(map.get(data[j]) + 1, i);
            }
            max = Math.max(max, j - i + 1);
            map.put(data[j], j);
        }
        return max;
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 0 || s == null) {
            return s;
        }
        int start = 0;
        int end = 0;
        int length = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int r = 0; r < s.length(); r++)
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l + 1 <= 3 || dp[l + 1][r - 1] == true)) {
                    dp[l][r] = true;
                    if (r - l + 1 >= length) {
                        length = r - l + 1;
                        start = l;
                        end = r;
                    }
                }
            }
        return s.substring(start, end + 1);
    }

    public int reverse(int x) {
        int y = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if ((y == Integer.MIN_VALUE / 10 && pop < -8) || y < Integer.MIN_VALUE / 10) {
                return 0;
            }
            if ((y == Integer.MAX_VALUE / 10) && pop > 7 || y > Integer.MAX_VALUE / 10) {
                return 0;
            }
            y = y * 10 + pop;

        }
        return y;
    }

    public int myAtoi(String str) {
        char[] data = str.trim().toCharArray();
        if (data == null || data.length <= 0) {
            return 0;
        }
        int flag = 1;
        int i = 0;
        int res = 0;
        if (data[0] == '+' || data[0] == '-') {
            if (data[0] == '-') {
                flag = -1;
            }
            i++;
        }
        for (; i < data.length; i++) {
            if (data[i] < '0' || data[i] > '9') {
                break;
            }
            if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10 && (data[i] - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (data[i] - '0') > 7)) {
                return Integer.MAX_VALUE;
            }
            res = res * 10 + flag * (data[i] - '0');
        }
        return res;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == x || x == res / 10;
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int ans = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, ans);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0 || strs == null) {
            return "";
        }
        return devideLongestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String devideLongestCommonPrefix(String[] strs, int left, int right) {
        if (left >= right) {
            return strs[left];
        }
        int mid = (left + right) >> 1;
        String lefts = devideLongestCommonPrefix(strs, left, mid);
        String rights = devideLongestCommonPrefix(strs, mid + 1, right);
        return findTwoLongestCommonPrefix(lefts, rights);
    }

    private String findTwoLongestCommonPrefix(String a, String b) {
        StringBuilder res = new StringBuilder();
        int length = Math.min(a.length(), b.length());
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return res.toString();
            }
            res.append(a.charAt(i));
        }
        return res.toString();
    }
}