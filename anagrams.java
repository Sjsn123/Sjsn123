import java.util.Arrays;
import java.util.Scanner;

public class anagrams {
    static int size = 256;
    static boolean isAnagram(String a, String b) {
        // Complete the function
        String A = a.toUpperCase();// Convert the whole string to upper case
        String B = b.toUpperCase(); // Convert the whole b string to upper case
        
        if(A.length() != B.length())
        return false;
        // we are creating the new size array
        
        int size1[] = new int[size];
        int size2[] = new int[size];
        
        // Now the convert the strings to character array so that you can sort it
        char [] str1 = A.toCharArray();
        Arrays.fill(size1, 0);
        char [] str2 = B.toCharArray();
        Arrays.fill(size2, 0 );
        //  now use for loop
        for(int i=0;i<str1.length && i<str2.length;i++){
                    size1[str1[i]]++;
                    size2[str2[i]]++;
        }
        // check the anagrams

        for(int i =0;i<a.length();i++){
            if(size1[i]!=size2[i]){
                return false;
                }
        }
        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
