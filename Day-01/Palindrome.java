public class Palindrome {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";

        boolean result = isPalindrome(input);

        System.out.println("Is palindrome? " + result);
    }

    public static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
