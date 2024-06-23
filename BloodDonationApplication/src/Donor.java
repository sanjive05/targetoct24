import java.sql.*;
import java.util.Scanner;

public class Donor {
    private static int donorOption;

    public Donor(int donorOption) {
        this.donorOption = donorOption;
    }
    public Donor(){

    }
    private static String currentAdminName;
    public void setCurrentAdminName(String currentAdminName){
        this.currentAdminName=currentAdminName;
    }


    static Scanner sc = new Scanner(System.in);
    static java.util.Date utilDate=new java.util.Date();

    public static void donorDataValidation() {
        if (donorOption ==1) {
            try {

                Connection con = DriverManager.getConnection(Credential.getConnectUrl(), Credential.getConnectUsername(), Credential.getConnectPassword());
                Statement st = con.createStatement();
                System.out.println("you are adding donor...");
                ResultSet rs = st.executeQuery("SELECT MAX(id) FROM donor"); // Replace 'users' with your table name
                int lastID = 0;
                if (rs.next()) {
                    lastID = rs.getInt(1);
                }
                if (lastID == 0) {
                    lastID = 1000;
                }
                lastID += 1;
                System.out.println("donor name :");
                String donorName = sc.nextLine();
                System.out.println("Age:");
                int age = sc.nextInt();
                System.out.println("phone no: ");
                long phoneNo=sc.nextLong();
                System.out.println("choose blood group : ");
                Messages.bloodgrouplist();
                int bloodno=sc.nextInt();
                String bloodGroup[]={"","A+","A-","B+","B-","AB+","AB-","O+","O-"};
                if(bloodno<1 || bloodno>8){
                    System.out.println("Incorrect input....");
                    return;
                }
                String bloopGroup=bloodGroup[bloodno];
                sc.nextLine();
                System.out.println("Address:");
                String address=sc.nextLine();
                rs = st.executeQuery("SELECT SYSDATE()");
                String date = null;

                if (rs.next()) {
                    date = rs.getString(1); // Assuming the result is stored in a column named "current_date"
                }
                String sql = "insert into donor values(?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, String.valueOf(lastID));
                preparedStatement.setString(2, donorName);
                preparedStatement.setString(3, String.valueOf(age));
                preparedStatement.setString(4, String.valueOf(phoneNo));
                preparedStatement.setString(5, bloopGroup);
                preparedStatement.setString(6, address);
                preparedStatement.setString(7, currentAdminName);
                preparedStatement.setString(8,date);
                System.out.println("Donor Added.....................................");
                System.out.println("Health Tips for donor:\n1.Please wait here at least 10 mins after donating the blood\n2.Take rest minimum half day!\n" +
                        "3.");
            }
            catch (Exception e){
                System.out.println(e);
            }

        } else if (donorOption==2) {
            try {
                System.out.println("you are updating donor details...");
                Connection con = DriverManager.getConnection(Credential.getConnectUrl(),Credential.getConnectUsername(),Credential.getConnectPassword());
                Statement st=con.createStatement();
                System.out.println("What do you want to update:");
                Messages.displayColumn();
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline left by nextInt()
                PreparedStatement pstmt = null;
                switch (choice) {
                    case 1:
                        System.out.println("Enter new donor id:");
                        int donorId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new donor name:");
                        String newName = sc.nextLine();
                        st.execute("UPDATE donor SET donorName ='"+newName+"' WHERE id ='"+donorId+"'");
                        System.out.println("data updated...");
                        break;
                    case 2:
                        System.out.println("Enter new donor id:");
                        donorId = sc.nextInt();
                        System.out.println("Enter new age:");
                        int newAge = sc.nextInt();
                        st.execute("UPDATE donor SET age ='"+newAge+"' WHERE id ='"+donorId+"'");
                        System.out.println("data updated...");
                        break;
                    case 3:
                        System.out.println("Enter new donor id:");
                        donorId = sc.nextInt();
                        System.out.println("Enter new phone number:");
                        long newPhoneNo = sc.nextLong();
                        st.execute("UPDATE donor SET phonenno ='"+newPhoneNo+"' WHERE id ='"+donorId+"'");
                        System.out.println("data updated...");
                        break;
                    case 4:
                        // Update for blood group
                        // Similar to other cases, get input and execute update query
                        System.out.println("Enter new donor id:");
                        donorId = sc.nextInt();
                        System.out.println("Enter Blood Group:");
                        String bloodGroup = sc.nextLine();
                        st.execute("UPDATE donor SET bloodgroup ='"+bloodGroup+"' WHERE id ='"+donorId+"'");
                        System.out.println("data updated...");

                        break;
                    case 5:
                        // Update for address
                        // Similar to other cases, get input and execute update query
                        System.out.println("Enter new donor id:");
                        donorId = sc.nextInt();
                        System.out.println("Enter Blood Address:");
                        String address = sc.nextLine();
                        st.execute("UPDATE donor SET address ='"+address+"' WHERE id ='"+donorId+"'");
                        System.out.println("data updated...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

            }
            catch (Exception e){
                System.out.println(e);
            }
        } else if (donorOption==3) {
            try {
                System.out.println("you are deleting donor details...");
                Connection con = DriverManager.getConnection(Credential.getConnectUrl(),Credential.getConnectUsername(),Credential.getConnectPassword());
                Statement st=con.createStatement();
                System.out.println("please enter the id for delete the data:");
                int donorId = sc.nextInt();
                st.execute("delete from donor WHERE id ="+donorId);
                System.out.println(donorId+"  data deleted....");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else if (donorOption==4) {
            try {
                Connection con = DriverManager.getConnection(Credential.getConnectUrl(),Credential.getConnectUsername(),Credential.getConnectPassword());
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from donor");
                while (rs.next()){
                    System.out.println(rs.getInt(1)+"\t "+rs.getString(2)+" \t"+rs.getInt(3)+"\t\t"+rs.getBigDecimal(4)+"\t\t"+rs.getString(5)+"\t\t "+rs.getString(6)+"\t\t "+rs.getString(7)+"\t\t "+rs.getDate(8));
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}



