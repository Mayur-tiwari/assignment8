public class Ass8Q8 {
    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
                if (count[ch - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }

        int firstIndex = -1, secondIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else if (secondIndex == -1) {
                    secondIndex = i;
                } else {
                    return false; // More than two indices differ
                }
            }
        }

        return (secondIndex != -1 && s.charAt(firstIndex) == goal.charAt(secondIndex) &&
                s.charAt(secondIndex) == goal.charAt(firstIndex));
    }
    public static void main(String[] args) {
        String s = "ab";
        String goal = "ba";

        boolean isPossible = buddyStrings(s, goal);

        System.out.println(isPossible);
    }
}
