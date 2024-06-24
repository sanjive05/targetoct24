import java.sql.*;
import java.util.Scanner;

public class AdminUser {
    private String username;
    Scanner sc=new Scanner(System.in);
    public int adminValidate () {
        try {
            Messages.printLine();
            Connection con = DriverManager.getConnection(Credential.getConnectUrl(),Credential.getConnectUsername(),Credential.getConnectPassword());
            Messages.askUsername();
            String inputUsername = sc.nextLine();
            this.username=inputUsername;
            Messages.askPassword();
            String inputPassword = sc.nextLine();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM admin WHERE userid='" + inputUsername + "' AND password='" + inputPassword + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Login successful!");
                Messages.printLine();
                Donor donor=new Donor();
                donor.setCurrentAdminName(inputUsername);
                return 1;
            } else {
                System.out.println("Invalid username or password.");
                Messages.printLine();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    public void adminCreation(){
         String LoginadminUsername=Credential.adminCreationUsername();
         String LoginadminPassword=Credential.adminCreationpassword();
        System.out.println("Enter the database admin username:");
        String inputUsername = sc.nextLine();
        System.out.println("Enter the database admin password:");
        String inputPassword = sc.nextLine();
        if(!(LoginadminUsername.equals(inputUsername) && LoginadminPassword.equals(inputPassword))){
            System.out.println("Sorry wrong database admin credentials!!!!!");
            return;
        }
        System.out.println(LoginadminUsername.equals(inputUsername));
        try {
            System.out.println("Creating new Admin...............................");
            Connection con = DriverManager.getConnection(Credential.getConnectUrl(),Credential.getConnectUsername(),Credential.getConnectPassword());
            Statement st = con.createStatement();
            System.out.println("Enter admin username:");
            String adminUsername=sc.nextLine();
            System.out.println("Enter admin password:");
            String adminUserpassword=sc.nextLine();
            String sql = "insert into admin values(?,?)";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,adminUsername);
            preparedStatement.setString(2,adminUserpassword);
            int affectedRows=preparedStatement.executeUpdate();
            System.out.println("Admin created.....");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
