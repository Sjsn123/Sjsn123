/*A Simple Banking Application in Java is an ideal project
for coding beginners. It covers fundamental concepts
like the Scanner class for input, strings, loops, methods,
and conditional statements. This project involves basic
banking operations such as deposits, withdrawals,
checking balances, and exiting the program.*/



import java.util.*;

class Bank_SignUp_Login{
    Scanner sc = new Scanner(System.in);
    ArrayList<String> Cutomer_Username = new ArrayList<>();
    ArrayList<String> Customer_password = new ArrayList<>();

    private void Customer_login_signup(String user_name, String pass){
        this.Cutomer_Username.add(user_name);
        this.Customer_password.add(pass);

    }
    public boolean signup(){
        System.out.println("Enter the user_name");
        String user = sc.nextLine();
        System.out.println("Enter the password");
        String pass = sc.nextLine();
        while(user.length()<8 && pass.length()<8){
            System.out.println("Password and username should be at least 9 characters long");
            System.out.println("Enter the user_name");
         user = sc.nextLine();
        System.out.println("Enter the password");
         pass = sc.nextLine();
        }
        System.out.println("Successfully Registered");
        System.out.println("Please enter the same details again to login");
        Customer_login_signup(user, pass);
        if(login()){
            return true;
        }
        return false;
    }
    
    public boolean update_sign(){

        for(int i=0;i<Customer_password.size();i++){
        System.out.println("Enter the user_name");
        String user = sc.nextLine();
        System.out.println("Enter the password");
        String pass = sc.nextLine();
        while(user.length()<8 && pass.length()<8){
            System.out.println("Password and username should be at least 9 characters long");
            System.out.println("Enter the user_name");
         user = sc.nextLine();
        System.out.println("Enter the password");
         pass = sc.nextLine();
        }
        System.out.println("Successfully Registered New user and Password.");
        System.out.println("Please enter the same details again to login");
        Cutomer_Username.set(i, user);
        Customer_password.set(i, pass);
        Customer_login_signup(user, pass);
        }
        return true;
    }

    public boolean login(){

        System.out.println("Enter the user_name");
        String user = sc.nextLine();
        System.out.println("Enter the password");
        String pass = sc.nextLine();
        int i=0,j=4;
        while(user.length()<8 && pass.length()<8){
            System.out.println("Password and username should be at least 9 characters long");
            System.out.println("Enter the user_name");
         user = sc.nextLine();
        System.out.println("Enter the password");
         pass = sc.nextLine();
        }
        if(Customer_password.isEmpty()&& Cutomer_Username.isEmpty()){
            System.out.println("No user is registered.");
            System.out.println("Do you want to signup. Yes or No ?");
            String yes= sc.nextLine();
            if(yes.equalsIgnoreCase("yes")){
                if(signup())
                return true;
            }
           
            else{
                    return false;
            }
        }else if(Cutomer_Username.get(i).equals(user)&& Customer_password.get(i).equals(pass)){
            System.out.println("Login Successfull Hooraayyyy!!");
            System.out.println("Welcome to the banking system");
            System.out.println("Please Do not share the username and password.");
            return true;
        }
        else{
            
            while(!Cutomer_Username.get(i).equals(user) && !Customer_password.get(i).equals(pass)){
                j--;
                System.out.println("Wrong input given. Please Continue.");
                System.out.println("Enter the user_name");
                 user = sc.nextLine();
                System.out.println("Enter the password");
                 pass = sc.nextLine();
                 System.out.println("Only "+j+ " attempts left");
                
                 if(j==0){
               System.out.println("If you have forgotten the input do you want to change it.");
               String yes= sc.nextLine();
               if(yes.equalsIgnoreCase("yes")){
                if(update_sign())
                return true;
                
                }
                else{
                    System.out.println("Terminating the program");
                return false;
                }
            }
            }
            
        }
        return false;
    }
    
}

class Bank extends Bank_SignUp_Login{
       static Scanner sc = new Scanner(System.in);
        static Random ra = new Random();
        private static  ArrayList<String> Customer_Name = new ArrayList<>();        //Stores the Name
        private static  ArrayList<Integer> Customer_Age = new ArrayList<>();        //Stores the Age
        private static  ArrayList<Integer> Customer_Amount= new ArrayList<>();      //Stores the Amount
        private static  ArrayList<String> Customer_Id = new ArrayList<>();          //Stores the Custommer Unique Id
        private static  ArrayList<String> Customer_Phone_No = new ArrayList<>();        //Stores the Phone No
        private  static ArrayList<String> Customer_Aadhar_No = new ArrayList<>();       //Stores the Aadhar No
        private static  ArrayList<String> Customer_Address = new ArrayList<>();         //Stores the Address
        private static  ArrayList<Integer> index = new ArrayList<>();       // stores the digits of phone which are masked.
        private static  char[] phoneNoArray ; // Created a phone array
 
        // The below will add all the data entered by user or store it.
    @SuppressWarnings("static-access")
    private static  void Customer_Info(String Id, String Name, int Age,int Amt,String Phone_no ,String Aadhar_No,String Address){
        Customer_Id.add(Id);
        Customer_Name.add(Name);
        Customer_Age.add(Age);
        Customer_Amount.add(Amt);
        Customer_Phone_No.add(Phone_no);
        Customer_Aadhar_No.add(Aadhar_No);
        Customer_Address.add(Address);
    }
     
    // Removes the customer's whole data as entered by user the unique customer id
    private static void Remove_Customer(String Id){
        for(int i=0;i<Customer_Id.size();i++){
            if(Customer_Id.get(i).equals(Id)){
                Customer_Id.remove(i);
                Customer_Name.remove(i);
                Customer_Age.remove(i);
                Customer_Amount.remove(i);
                Customer_Phone_No.remove(i);
                Customer_Aadhar_No.remove(i);
                Customer_Address.remove(i);
                System.out.println();
                System.out.println("The data has been successfully removed");
                System.out.println();
            break;
            }
        }
    }
   
   // Removes all the lists of the Bank Database 
    private static void Remove_List(){
        System.out.println("Enter what you want to remove");
        System.out.println("1. Row");
        System.out.println("2. All List");
        int choice = sc.nextInt();
        if(Customer_Id.isEmpty() && Customer_Name.isEmpty() && Customer_Amount.isEmpty()&& Customer_Age.isEmpty() && Customer_Phone_No.isEmpty() && Customer_Aadhar_No.isEmpty()){
            System.out.println("List is empty.");
            System.out.println("You might need to add a user or customer.");
            System.out.println("Do you want to add it.");
            String yes = sc.next();
            if(yes.equalsIgnoreCase("yes")){
                Create_Account();
            }
            else{
                System.exit(0);
            }
        }
        if(choice == 1){
            System.out.println("Enter the Customer Id you want to remove");
            String ID = sc.next();
           Remove_Customer(ID);
            }
            else if(choice==2){
                Customer_Name.clear();
                Customer_Age.clear();
                Customer_Amount.clear();
                Customer_Id.clear();
                Customer_Phone_No.clear();
                Customer_Aadhar_No.clear();
                Customer_Address.clear();
            }
            else{
                System.out.println("Invalid choice");

            }
    }

    // It helps to withdraw the amount
    private static void Withdraw(){
        if(Customer_Amount.isEmpty()){
            System.out.println("The balance is Empty. No data is present. You are being directed to main creation Account");
            System.out.println();
            Create_Account();
        }
        else{
        System.out.println("Do you want to Withdraw the Amoount ");
        System.out.println("Tell either yes or no.");
        sc.nextLine();
        String choice3 = sc.next();
        if(choice3.equalsIgnoreCase("yes")){
            System.out.println("Enter your Id Sir.");
            System.out.println("Do you want to check your Id.Write Only yes or no");
                String cho = sc.next();
                if(cho.equalsIgnoreCase("yes")){
                    display();
                    System.out.println("Enter your Id Sir");
                    String Id = sc.next();
                    System.out.println("Enter your Name Sir");
                    sc.nextLine();
                    String Name = sc.nextLine();
                    for(int i =0;i<Customer_Name.size();i++){
        
                        if(Customer_Id.get(i).equals(Id) && Customer_Name.get(i).equals(Name)){
                            System.out.println("You are eligible to Withdraw the Amount");
                            System.out.println(" Dear Customer! Please enter the Amount you want to Withdraw:");
                            int amount = sc.nextInt();
                            while( (Customer_Amount.get(i) - amount)<500){
                                System.out.println("You are not eligible to Withdraw the Amount");
                                System.out.println("The minimum balance should be Rs 500");
                                System.out.println(" Dear Customer! Please enter the Amount you want to Withdraw:");
                                 amount = sc.nextInt();
                            
                            }
                          
                            Customer_Amount.set(i, Customer_Amount.get(i) - amount);
                            System.out.println("Withdrawal Successful");
                            System.out.print("Dear Customer, Your Account has been Successfully Debited by: ");
                            System.out.println(" Rs. "+amount);
                            System.out.print("Your Current Balance is:");
                            System.out.println(Customer_Amount.get(i));
                        
                    }
                    else{
                        while(!Customer_Id.get(i).equals(Id)&& !Customer_Name.get(i).equals(Name)){
                            System.out.println("Wrong input given");
                            System.out.println("Enter your Id Sir");
                             Id = sc.next();
                            System.out.println("Enter your Name Sir");
                            sc.nextLine();
                             Name = sc.nextLine();
                        }
                    }
                    }
                }
                else{
                    System.out.println("Enter your Id Sir");
            String Id = sc.next();
            System.out.println("Enter your Name Sir");
            sc.nextLine();
            String Name = sc.nextLine();
            for(int i =0;i<Customer_Name.size();i++){

                if(Customer_Id.get(i).equals(Id) && Customer_Name.get(i).equalsIgnoreCase(Name)){
                    System.out.println("You are eligible to Withdraw the Amount");
                    System.out.println(" Dear Customer! Please enter the Amount you want to Withdraw:");
                    int amount = sc.nextInt();
                    Customer_Amount.set(i, Customer_Amount.get(i) - amount);
                    System.out.println("Withdrawal Successful");
                    System.out.print("Dear Customer, Your Account has been Successfully Debited by: ");
                    System.out.println(" Rs. "+amount);
                    System.out.println("Your Current Balance is:");
                    System.out.println(Customer_Amount.get(i));
                }
            }
        }
            
    }
    else{
        update();
    }
}
    }
   
//    It helps to update the age
    private static void Age_Update(){
        
        System.out.println("Enter your Name Sir");
        sc.nextLine();
        String Name = sc.nextLine();
        System.out.println("Enter your Id Sir");
        String Id = sc.next();
        int i=0;
        while (!Customer_Id.get(i).equals(Id) && !Customer_Name.get(i).equalsIgnoreCase(Name) ) {
            System.out.println(" Wrong Input given. ENter again");
            System.out.println("Enter your Name Sir");
            sc.nextLine();
            Name = sc.nextLine();
            System.out.println("Enter your Id Sir");
             Id = sc.next();
        }
        System.out.println("Enter your New Age Sir.");
        int Age = sc.nextInt();
       
            if(Customer_Age.isEmpty()){
                System.out.println("The list of Age is Empty. You are being diverted to main Creation Account");
                Create_Account();
            }
        
        else{
       if(Age>=18){
       
            if(Customer_Name.get(i).equals(Name) && Customer_Id.get(i).equals(Id)){
                Customer_Age.set(i,Age);
                System.out.println("Age Updated Successfully");
                return;
                }
        
            
        }
    
        else{
            System.out.println("You are not eligible to open a bank account!");
    }
}
    }
   
//    It helps to update the Aadhar no
    private static void Aadhar_No_update(){
       if(Customer_Aadhar_No.isEmpty()){
        System.out.println("There is no Aadhar Number in the list. You  are being directed to main Creaationn Account.");
        Create_Account();
       }
       else{
        System.out.println("Dear Custmer Enter your Customer Unique Id");
        String Id = sc.next();
        for(int i=0;i<Customer_Id.size();i++){
            if(Customer_Id.get(i).equals(Id)){
                System.out.println("Enter your name");
                sc.nextLine();
                String Name = sc.nextLine();
                System.out.println("Enter your New Aadhar Number");
                String Aadhar_No = sc.nextLine();
                
                while(Aadhar_No.length()!=12){
                    System.out.println("Dear Sir, Enter your Aadhar No. The Aadhar No should be of 12 Digits.");
                 Aadhar_No = sc.nextLine();
                }
               
                    if(Customer_Aadhar_No.get(i).equals(Aadhar_No)){
                        System.out.println("Your Aadhar No is already registered.");
                    }
                    else{
                        Aadhar_No= masked_private_aadhar(Aadhar_No);
                        Customer_Aadhar_No.set(i,Aadhar_No);
                        System.out.println("Aadhar No Updated Successfully");
                        Customer_Id_update(Name);
                    }
                
            }
        }
       
    }
    }
  
    // It will update the Address
    private static void Address_Update(){
        System.out.println("Enter your Name Sir");
        sc.nextLine();
        String Name = sc.nextLine();
        System.out.println("Enter your Id Sir");
        String Id = sc.next();
        int i=0;
        while (!Customer_Id.get(i).equals(Id) && !Customer_Name.get(i).equalsIgnoreCase(Name) ) {
            System.out.println(" Wrong Input given. Enter again");
            System.out.println("Enter your Name Sir");
            Name = sc.nextLine();
            System.out.println("Enter your Id Sir");
             Id = sc.next();
             
        }
        System.out.println("Enter your New Address Sir.");
        sc.nextLine();
        String Address = sc.nextLine();
        
        Customer_Address.set(i,Address);
        if(Customer_Address.isEmpty()){
            System.out.println("You might need to add a address. You are being directed to creation account.");
            Create_Account();
        }
        else{
            if(Customer_Name.get(i).equals(Name) && Customer_Id.get(i).equals(Id)){
                Customer_Address.set(i,Address);
                System.out.println("Address Updated Successfully");
                return;
                }
        }
    }
//   It helps to update the phone
      private static void Phone_no_update(){
       
       
        if(Customer_Id.isEmpty()){
            System.out.println("Customer Id is not found");
            System.out.println("You have been transferred to main Account");
            Create_Account();
        }
        else{
            System.out.println("Enter the customer id to update phone number");
            String Id = sc.next();
        int index = Customer_Id.indexOf(Id);
        if(index != -1){
            System.out.println("Enter the new phone number");
            String Phone_no = sc.next();
            while(Phone_no.length()!=10){
                System.out.println("Enter the new phone number. The Phone no you entered should consist of 10 digits.");
                 Phone_no = sc.next();
                 
            }
            Customer_Phone_No.set(index,Phone_no);
            masked_private_PhoneNo(Phone_no);
            System.out.println("Phone number updated successfully");
            }
        }
          
    }
    
    // It helps to update The cutomer id as customer id depends on aadhar no and name of the cutomer
    private static void Customer_Id_update(String Name){
        System.out.println("Please wait a moment Sir! Your Unique Customer Id is being Generated");
        String aadhar_no;
        for(int i=0;i<Customer_Aadhar_No.size();i++){
            if(Customer_Name.get(i).equals(Name)){
                 aadhar_no = Customer_Aadhar_No.get(i);
                 String key = Name.substring(0, 3) + "_" + aadhar_no.substring(aadhar_no.length() - 4);
                 Customer_Id.set(i, key);
        }
       
    }
    }
   
    // It helps to update the name of the customer
    private static void name_update(){
      
        if(Customer_Id.isEmpty()){
            System.out.println("Customer Id is not found");
            System.out.println("You have been transferred to main Account");
            Create_Account();
        }
        else{
            System.out.println("Enter the customer id to update the name");
            String id = sc.next();
        int index = Customer_Id.indexOf(id);
        if(index >=0 ){
            
            System.out.println("Enter the new name");
            sc.nextLine();
            String name = sc.nextLine();
            Customer_Name.set(index,name);
            System.out.println("Name updated successfully");
            Customer_Id_update(name);
        }
        else{
            System.out.println("Wrong Input Given");
        }
    }
        
    }
  
//   It is the main update function which calls for all the updates
    public static void update(){
        while (true) {
        System.out.println("Do you want to update or remove your name or any other private credentials");
        System.out.println("Tell either yes or no.");
        String choice1 = sc.next();
        if(choice1.equalsIgnoreCase("yes")){
            System.out.println("What do you want to update Sir. Please tell");
            System.out.println("1. Create Account.");
            System.out.println("2. Update Name.");
            System.out.println("3. Update Phone No.");
            System.out.println("4. Update Aadhar No.");
            System.out.println("5. Update Age.");
            System.out.println("6.Update Address");
            System.out.println("7. Withdraw Amuont.");
            System.out.println("8. Deposit Amount.");
            System.out.println("9. Remove List.");
            System.out.println("10. Exit");
            int choice2 = sc.nextInt();
            
            switch (choice2) {
                case 1:
                Create_Account();
                display();
                break;
                case 2: 
                name_update();
                display();
                break;
                case 3:
                Phone_no_update();
                display();
                break;
                case 4:
                Aadhar_No_update();
                display();
                break;
                case 5:
                Age_Update();
                display();
                break;
                case 6: 
                Address_Update();
                display();
                break;
                
                case 7:
                Withdraw();
                display();
                break;
                
                case 8:
                add_deposit();
               display();
               break;
               case 9:
               Remove_List();
               display();
               break;

               case 10:
               System.exit(0);  
               break;
                default:
                    break;
            }
            
        }
        else{
            System.out.println("Thank you for using our services");
            break;
        }
        
        }
    }
 
//  It will unmask or make the phone number visible but only for Otp purposes.
    private static String unmaskPhoneNumber(String originalPhoneNo){
    while (!originalPhoneNo.matches("\\d+")) {
    System.out.println("Sir ! The phone number you entered is not appropriate.");
    System.out.println("Please enter it again.");
    System.out.println("Please Enter your Phone Number. The phone number consists of 10 digits");
    originalPhoneNo = sc.next(); // Get the original phone number from the user again
    phoneNoArray = originalPhoneNo.toCharArray();
    index.clear(); // Clear the indices list

    for (int i = 0; i < phoneNoArray.length; i++) {
        if (i >= 3 && i < phoneNoArray.length - 3) {
            index.add(i); // Store the indices of the digits to be replaced
        }
    }

    for (int i = index.size() - 1; i >= 0; i--) {
        phoneNoArray[index.get(i)] = originalPhoneNo.charAt(index.get(i)); // Unmask the phone number
    }

    originalPhoneNo = new String(phoneNoArray); // Update the original phone number
   
}
return originalPhoneNo;
}

// It will provide an OTp to the Customer on the mobile no as entered by user.
   private static void OTP(String mobile_no){
   String mobile_no_unmask =unmaskPhoneNumber(mobile_no);
  
   for(int i =0;i< Customer_Phone_No.size();i++){
     while(mobile_no.matches(mobile_no_unmask)){
    System.out.println("An Otp of 6 digits has been sent to your Mobile no");
    int otp_int = ra.nextInt(100000,999999);
    String otp = String.valueOf(otp_int);
    System.out.println("Your OTP is "+otp);
    System.out.println("Enter the Otp Sir");
    String enteredOtp = sc.next();
    if (enteredOtp.equals(otp)) {
        System.out.println("OTP Verification Successful.");
        break;
    }
    else{
        System.out.println("Please Enter the OTP again");
        System.out.println("Enter the Otp Sir");
         enteredOtp = sc.next();
        if (enteredOtp.equals(otp)) {
            System.out.println("OTP Verification Successful.");
        }
        System.out.println("A new OTP has been sent in your mobile Number.");
        OTP(mobile_no);
    }
}

   }
  
}

//  This will add or deposit the amount into the customers bank account.
    private static void add_deposit(){
        System.out.println("Do you want to Add or Deposit some the Amoount ");
        System.out.println("Tell either yes or no.");
        String choice = sc.next();
        
        if(choice.equalsIgnoreCase("yes")){
            System.out.println("Enter your Last 4 digit aadhar No Sir.");
            System.out.println("Do you want to check your Aadhar Id.Write Only yes or no");
                String cho = sc.next();
                if(cho.equalsIgnoreCase("yes")){
                    display();
                    System.out.println("Enter the last 4 digits of you Aadhar Number");
                    String aadharLast4Digits = sc.next();
                    if (aadharLast4Digits.matches("\\d{4}")) {
                        System.out.println("Enter your Phone no");
                        String mobile_no = sc.next();
                        int i =0,j=3;
                      while((mobile_no.length()!=10) || (Customer_Phone_No.get(i).equals(mobile_no) && j>=1)){
                        System.out.println("Your phone number does not match. Please write again.");
                        System.out.println("Only"+i+"attempts left");
                         mobile_no = sc.next();
                         j--;
                         break;
                      }
                       OTP(mobile_no);
                       System.out.println("Enter your Id Sir");
                       String Id = sc.next();
                       while ( !Customer_Id.get(i).equals(Id)) {
                        System.out.println("Wrong Input given");
                        System.out.println("Enter your ID again ");
                       Id = sc.next();
                    }
                       System.out.println("Enter your Name Sir");
                       sc.nextLine();
                       String Name = sc.nextLine();
                       while ( !Customer_Name.get(i).equals(Name)) {
                        System.out.println("Wrong Input given");
                        System.out.println("Enter your Name again ");
                        Name = sc.nextLine();
                    }
                       for( i =0;i<Customer_Name.size();i++){
           
                           if(Customer_Id.get(i).equals(Id) && Customer_Name.get(i).equalsIgnoreCase(Name)){
                               System.out.println("You are eligible to deposit the Amount");
                               System.out.println(" Dear Customer! Please enter the Amount you want to Deposit:");
                               int amount = sc.nextInt();
                               sc.nextLine();
                               Customer_Amount.set(i, Customer_Amount.get(i) + amount);
                               System.out.println("Deposit Successful");
                               System.out.print("Dear Customer, Your Account has been Successfully Credited by: ");
                               System.out.println(" Rs. "+amount);
                               System.out.print("Your Current Balance is:");
                               System.out.println("Rs. "+Customer_Amount.get(i));
                               display();
                               update();
                               }
                           else{
                               System.out.println("You are not eligible to deposit the Amount");
                           }}
                        }
                        else{
                            System.out.println("Your Mobile Number is not in our Database");
                        }
                    
                    } 
                  else  if(cho.equalsIgnoreCase("no")){
                       
                        System.out.println("Enter the last 4 digits of you Aadhar Number");
                        String aadharLast4Digits = sc.next();
                        if (aadharLast4Digits.matches("\\d{4}")) {
                            System.out.println("Enter your Phone no");
                            String mobile_no = sc.next();
                            int i =0,j=1;
                      while((mobile_no.length()!=10) || (Customer_Phone_No.get(i).equals(mobile_no) && j>=3)){
                        System.out.println("Your phone number does not match. Please write again.");
                        System.out.println("Only"+i+"attempts left");
                         mobile_no = sc.next();
                         j--;
                         break;
                      }
                            OTP(mobile_no);
                            System.out.println("Enter your Id Sir");
                           
                            String Id = sc.next();
                            while ( !Customer_Id.get(i).equals(Id)) {
                                System.out.println("Wrong Input given");
                                System.out.println("Enter your ID again ");
                               Id = sc.next();
                            }
                            System.out.println("Enter your Name Sir");
                            
                            String Name = sc.nextLine();
                            while (!Customer_Name.get(i).equals(Name)) {
                                System.out.println("Wrong Input given");
                                System.out.println("Enter your Name again ");
                                Name = sc.nextLine();
                            }
                for( i =0;i<Customer_Name.size();i++){
    
                    if(Customer_Id.get(i).equals(Id) && Customer_Name.get(i).equalsIgnoreCase(Name)){
                        System.out.println("You are eligible to deposit the Amount");
                        System.out.println(" Dear Customer! Please enter the Amount you want to Deposit:");
                        int amount = sc.nextInt();
                        Customer_Amount.set(i, Customer_Amount.get(i) + amount);
                        System.out.println("Deposit Successful");
                        System.out.print("Dear Customer, Your Account has been Successfully Credited by: ");
                        System.out.println(" Rs. "+amount);
                        System.out.print("Your Current Balance is:");
                        System.out.println("Rs. "+Customer_Amount.get(i));
                       display();
                       update();
                    }
                    else{
                        System.out.println("Missing or Wrong information");
                    }
                }
            }
            } 
            else{
                System.out.println("Invalid Input");
            }

  }
  else{
    update();
  }
}

    // It will make the phone number hide for seccurity purposes.
    private static String masked_private_PhoneNo(String phone){
    char[] phoneNoArray = phone.toCharArray();
    for (int i = 3; i < phoneNoArray.length - 3; i++) {
        phoneNoArray[i] = '*'; // Replace digits with * characters
    }
    String maskedPhone = new String(phoneNoArray);
    return maskedPhone;
}
    
        // It will make the Aadhar number hide for seccurity purposes.
    private static String masked_private_aadhar(String Aadhar){
    String maskedAadhar = Aadhar;

    while (!maskedAadhar.matches("\\d+")) {
        System.out.println("Sir ! The Aadhar number you entered is not appropriate.");
        System.out.println("Please enter it again.");
        System.out.println("Please Enter your Aadhar no Number. The Aadhar number consists of 12 digits");
        maskedAadhar = sc.next();
    }
    maskedAadhar = Aadhar.substring(0, 8).replaceAll("\\d", "*") + Aadhar.substring(8);
    return maskedAadhar;

}
   
//  it helps in creation of Customer account
        private static void Create_Account(){

                /* Take the name as input loop continues till the name is not entered  */
                System.out.println("Please Enter your Name Sir:");
                sc.nextLine();
                String name = sc.nextLine();
                
                if (name.isEmpty()) {
                    System.out.println("Please Enter your Name Sir:");
                    name = sc.nextLine();
                }
                /* Take the Country as input loop continues till India is not entered. */
                System.out.println("Please Enter your country Sir. Only India is accepted.");
                String Country = sc.next();
                sc.nextLine();
               String country= Country.toUpperCase();
                while(!country.equals("INDIA")){
                    System.out.println("Sorry Sir ! You are not eligible to create your Account");
                    System.out.println("Sorry Sir! This system works only for Indian People");
                    System.out.println("Please Enter your country Sir");
                 Country = sc.next();
                 country= Country.toUpperCase();
                if(Country.equalsIgnoreCase("India")){
                    System.out.println("Dear Sir ! You are eligible to create your Account");
                }
               
                }
                /* Take the Age as input loop continues till age is not greater than 18. */
                System.out.println("Please Enter your Age Sir:");
                int age = sc.nextInt();
                sc.nextLine();
                while(age<18){
                    System.out.println("To open the Bank Account the minimum age should be 18 or 18+ ");
                    System.out.println("Please Enter your Age Sir:");
                     age = sc.nextInt();
                }
               
                /* Take the Deposit Amount as input loop continues till amount is not greater than or equal to 500 . */
                System.out.println("Please Deposit Rs 500 or above for your minimum balance");
                int amount = sc.nextInt();
                sc.nextLine();
               while(amount<500){
                System.out.println("Sir ! Please enter the amount equal to or more 500 Rupees");
                System.out.println("Please Deposit Rs 500 or above for your minimum balance");
                 amount = sc.nextInt();
               }
               
               /* Take the Phone No as input loop continues till Phone no lenght is notequal to 10. */
               System.out.println("Please Enter your phone number Sir in 10 digits: +91");
              
               String phone_no = sc.nextLine();
               
                while (phone_no.length()!=10) {
                    System.out.println("Sir ! The phone number you entered is not appropriate.");
                    System.out.println("Please enter it again.");
                    System.out.println("Please Enter your phone number Sir in 10 digits: +91");
                 phone_no = sc.next();
                }
                phone_no = masked_private_PhoneNo(phone_no); // it will make the phone no confidential

                /* Take the Aadhar No as input loop continues till Aadhar no lenght is notequal to 10. */
                System.out.println("Please Enter your Aadhar Number. The addhar number consists of 12 digits");
                    String aadhar_no = sc.next();
               
                    while (aadhar_no.length()!=12) {
                        System.out.println("Sir ! The Aadhar number you entered is not appropriate.");
                        System.out.println("Please enter it again.");
                        System.out.println("Please Enter your Aadhar Number. The addhar number consists of 12 digits");
                    aadhar_no = sc.next();
                    
                    }
                 aadhar_no= masked_private_aadhar(aadhar_no); // it will make the aadhaar no confidential.
              
               System.out.println();
                System.out.println("Please wait a moment Sir! Your Unique Customer Id is being Generated");
                System.out.println("Enter your Address");
                sc.nextLine();
                String address = sc.nextLine();
               
                // System.out.println();
                String key = name.substring(0, 3) + "_" + aadhar_no.substring(aadhar_no.length() - 4);
               System.out.println();
                Customer_Info(key,name, age, amount,phone_no,aadhar_no,address);
                display();
                add_deposit();
                
            }
          
        //   It carries for the starting purpose
            public static void process(){
                    System.out.println("Do you want to deposit the amount");
                    System.out.println("Tell either yes or no.");
                    String choice = sc.next();
                   
                    if(choice.equalsIgnoreCase("yes")){
                        System.out.println("Dear Sir ! Please enter your name ");
                        
                        String name1 = sc.nextLine();
                        sc.nextLine();
                        if(Customer_Id.isEmpty() && Customer_Name.isEmpty()){
                            System.out.println("Dear Sir There is no account being created in your name.");
                            System.out.println("Do you want to create a new Account");
                            System.out.println("Tell either yes or no.");
                            String choice1 = sc.next();
                            if(choice1.equalsIgnoreCase("yes")){
                                Create_Account();
                        }
                            else{
                                System.out.println("Thank you for visiting our Bank");
                                System.exit(0);
                            }
                }
                else{
                    for(int i=0;i<Customer_Name.size();i++){
                        if(name1.equals(Customer_Name.get(i))){
                            add_deposit();
                            
                        }
                    }
                    
                }
            }
            else{
                System.out.println("Thank you for visiting our Bank");
                System.exit(0);
            }
            
}
               
    //  It will display the database.
        public static void display(){
                    System.out.printf("%-20s | %-26s | %-17s | %-9s | %-13s | %-15s | %-30s %n", "Cust_Id", "Cust_Name", "Cust_Deposit_Amt", "Cust_Age","Cust_Phone_No","Cust_Aadhar_No","Cust_Address");

                    for(int i = 0; i < Customer_Name.size(); i++){
                        System.out.printf("%-20s | %-26s | %-17s | %-9s | %-13s | %-15s |%-30s %n", Customer_Id.get(i), Customer_Name.get(i), Customer_Amount.get(i), Customer_Age.get(i),Customer_Phone_No.get(i),Customer_Aadhar_No.get(i),Customer_Address.get(i));
                    }   
                   
                    if(Customer_Id.isEmpty() && Customer_Name.isEmpty() && Customer_Amount.isEmpty()&& Customer_Age.isEmpty() && Customer_Phone_No.isEmpty() && Customer_Aadhar_No.isEmpty() && Customer_Address.isEmpty()){
                        System.out.println("List is empty.");
                        System.out.println("You might need to add a user or customer.");
                        System.out.println("Do you want to add it. Yes or No ?");
                        String yes = sc.next();
                        if(yes.equalsIgnoreCase("yes")){
                            sc.nextLine();
                            Create_Account();
                            
                        }
                        else{
                            System.exit(0);
                        }
                }
            }

            public static void main(String[] args) {
                Bank Bank = new Bank();
        Bank.menu();
            }

            public void menu(){
                System.out.println("Enter what you want to do");
                System.out.println(" 1. Deposit Amount");
                System.out.println(" 2.Display Data");
                System.out.println(" 3.Update The data");
                System.out.println(" 4.Exit");
                int choice = sc.nextInt();
                switch(choice){
                    case 1:
                    Bank.process();
                    break;
        
                    case 2:
                    
                    Bank.display();
                    
                    break;
                    
                    case 3:
                    Bank.update();
                    break;
        
                    case 4:
                    System.out.println("Thank you for visiting our Bank");
                    System.exit(0);
                    break;
                }
            }
}


public class Banker {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank Bank = new Bank();
        System.out.println("Do you want to Create an account. Yes or No ?");
        String yes = sc.next();
        if(yes.equalsIgnoreCase("yes")){
            System.out.println("1.Login if already Signup");
            System.out.println("2. Signup");
            int choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                   if(Bank.login()){
                       Bank.menu();
                   } 
                    break;
                case 2:
                if(Bank.signup()){
                    Bank.menu();
                }
                break;
                default:
                System.out.println("Invalid choice");
                    break;
            }
        }
       
    }}

