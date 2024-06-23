import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BloodDonationTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=0;
        while (n!=9) {
            AdminUser admin = new AdminUser();
            Messages.wellcomeMessage();
            Messages.loginOptionMessage();
            n=sc.nextInt();
            if(n==1) {
                if (admin.adminValidate() == 0) {
                    System.out.println("Sorry Access denied...");
                    return;
                }
                else{
                    Messages.printStar();
                    Messages.DonorOption();
                    int donorOption=sc.nextInt();
                    Donor dn=new Donor(donorOption);
                    Donor.donorDataValidation();

                }
            }
            else if (n==2) {
                admin.adminCreation();
            } else if (n==9) {
                System.out.println("Logout successfully.");
                break;
            }
        }

    }
}
