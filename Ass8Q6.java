import java.util.ArrayList;
import java.util.List;
public class Ass8Q6 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();

        if (s.length() < p.length()) {
            return indices;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count the frequency of characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Slide a window of size p.length() over s and compare the character counts
        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the window
            sCount[s.charAt(i) - 'a']++;

            // Remove the character outside the window
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare the character counts
            if (i >= p.length() - 1 && matches(pCount, sCount)) {
                indices.add(i - p.length() + 1);
            }
        }

        return indices;
    }

    private static boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> indices = findAnagrams(s, p);

        System.out.println(indices);
    }
}
