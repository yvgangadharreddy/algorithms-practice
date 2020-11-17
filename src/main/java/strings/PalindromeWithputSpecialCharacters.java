package strings;
/**Check if the given string is palindrome or not
 1) ignore case
 2) ignore numbers
 3) ignore special characters

 ex: anN$a5 is palindrome

 NO copy of string to be created
 no string reverse*/
public class PalindromeWithputSpecialCharacters {
    public static void main( String [] args )
    {
        System.out.println(checkPalindrome("anN$a5"));
    }

    private static String checkPalindrome(String s) {
        int i=0;
        int j = s.length() -1;
        while (i < j) {
            if (!Character.isLetter(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetter(s.charAt(j))) {
                j--;
                continue;
            }

            if (s.toLowerCase().charAt(i) != s.toLowerCase().charAt(j)) {
                return "Not a palindrome";
            }
            i++;
            j--;
        }
        return "The given string is a palindrome";
    }
}
