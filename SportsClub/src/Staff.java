public class Staff {
    private final String staffId;
    private final String staffName;
    private final String username;
    private String password;
    private String role;

    // Constructor
    public Staff(String staffId, String staffName, String username, String password, String role) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter methods
    public String getStaffId() {
        return staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Setter methods
    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Display staff information
    public void displayInfo() {
        System.out.println("Staff ID: " + staffId);
        System.out.println("Staff ID: " + staffId);
        System.out.println("Username: " + username);
        System.out.println("Role: " + role);
    }

    // Placeholder method for adding members
    public void addMember() {
        System.out.println("Adding a new member (to be implemented).");
    }

    // Placeholder method for viewing member details
    public void viewMemberDetails() {
        System.out.println("Viewing member details (to be implemented).");
    }

    // Placeholder method for generating reports
    public void generateReports() {
        System.out.println("Generating reports (to be implemented).");
    }
}

