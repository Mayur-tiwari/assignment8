public class Ass8Q5 {
    public static int compress(char[] chars) {
        int n = chars.length;
        int index = 0; // Index to track the current position in the modified array
        int count = 1; // Count to track the consecutive repeating characters

        for (int i = 1; i <= n; i++) {
            if (i < n && chars[i] == chars[i - 1]) {
                count++;
            } else {
                chars[index++] = chars[i - 1]; // Append the character to the modified array

                if (count > 1) {
                    // Append the count as characters to the modified array
                    String countStr = String.valueOf(count);
                    for (char c : countStr.toCharArray()) {
                        chars[index++] = c;
                    }
                }

                count = 1; // Reset the count for the new group of characters
            }
        }

        return index;
    }
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        int newLength = compress(chars);

        System.out.println(newLength);
        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i] + " ");
        }
    }
}
