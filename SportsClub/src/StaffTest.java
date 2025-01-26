public class StaffTest {
    public static void main(String[] args) {
        // Create a new Staff member
        Staff staffMember1 = new Staff("S1001", "Eve", "eve_staff", "staff_pwd1", "Receptionist");

        // Display the Staff member's information
        System.out.println("Staff Member 1 Information:");
        staffMember1.displayInfo();

        // Call placeholder methods
        staffMember1.addMember();
        staffMember1.viewMemberDetails();
        staffMember1.generateReports();
    }
}

