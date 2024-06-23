public class Messages {
    public static void wellcomeMessage(){
        System.out.println("************************* Hello Welcome to Blood Donation Camp *************************");
    }
    public static void askUsername(){
        System.out.println("Enter your username: ");
    }
    public static void askPassword(){
        System.out.println("Enter your password: ");
    }
    public static void loginOptionMessage(){
        System.out.println("Login press ===> 1 \n\nCreate new \nAdmin press ===> 2\n\nlogout press ===> 9");
    }
    public static void DonorOption(){
        System.out.println("Hey Hello!!!\nAdding donor details press 1 \nupdate donor datails press 2 \ndelete donor details press" +
                " 3 \nviewing donor details press 4");
    }
    public static void displayColumn(){
        System.out.println("donorname press 1\nage press 2\nphoneno press 3\nblood group press 4\naddress press 5");
    }
    public static void bloodgrouplist(){
        System.out.println("A positive (A+) press 1\n" +
                "A negative (A-). press 2\n" +
                "B positive (B+). press 3\n" +
                "B negative (B-). press 4\n" +
                "AB positive (AB+). press 5 \n" +
                "AB negative (AB-). press 6\n" +
                "O positive (O+). press 7\n" +
                "O negative (O-). press 8");
    }
    public static void printLine(){
        System.out.println("==================================================");
    }
    public static void printStar(){
        System.out.println("*************************************************");
    }
}
