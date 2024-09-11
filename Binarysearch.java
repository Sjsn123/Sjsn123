
import java.util.*;
import java.time.*;
public class Binarysearch {

   // Creating the function for taking the input from user
     public void Taking_the_input(){
       
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter the  size of an array");
        size = sc.nextInt();
        int [] arr = new int[size];
        System.out.println("Enter the elements of an array");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        Sorting_the_element(arr,size);
    for(int a=0;a<size;a++){
        System.out.print(arr[a]+" ");
    }
    System.out.println();
   binary_search(arr,size-1);
        }

        // Creating a function for the sorting the arrays

   void Sorting_the_element(int []arr,int size){
    for(int i=0;i<size;i++){
        for(int j=i+1;j<size;j++){
            if(arr[i]>arr[j]){
                System.out.println("Arrays are not sorted. It is starting to sort now");
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
        }
        }
}
System.out.println("Arrays are now sorted.  Printing the sorted arrays");
   }
  protected int binary_search(int [] arr,int size){
       
        Scanner sc = new Scanner(System.in);
        int first = 0;
            int last = arr.length;
            int find_element;
            System.out.println("Enter the element you want to find");
            find_element=sc.nextInt();
            while(first<=last){
                int mid = (first+last)/2;
                if(arr[mid]==find_element){
                    System.out.println("Element found at position "+mid);
                   break;
                }
                else if (find_element>arr[mid]) {
                   first=mid+1;
                }
                else if(find_element<arr[mid]){
                     last=mid-1;
                }
                else{
                    System.out.println("Element not found");
                    break;
                }
            }
            return -1;
    }
    
    public static void main(String[] args) {
        LocalDate myObj = LocalDate.now(); // Create a date object
        LocalDateTime ldm = LocalDateTime.now();
    System.out.println(myObj); // Display the current date
    System.out.println(ldm); // Display the current date

    
        Binarysearch bs = new Binarysearch();
        bs.Taking_the_input();
       
       
}
}