import java.util.*;
public class Ass8Q1 {
    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a 2D array to store the minimum ASCII sum of deleted characters
        int[][] dp = new int[m + 1][n + 1];

        // Calculate the cumulative ASCII sum for string s1
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        // Calculate the cumulative ASCII sum for string s2
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        // Calculate the minimum ASCII sum for each substring
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters at the current positions are equal, no deletion is required
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Delete the character with the minimum ASCII value and update the sum
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }

        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();

        int result = minimumDeleteSum(s1, s2);

        System.out.println(result);
    }
}
