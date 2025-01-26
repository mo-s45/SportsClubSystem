import java.io.*;
import java.util.*;

public class ClubManager {
    private List<Member> members;

    public ClubManager() {
        members = new ArrayList<>();
        loadMembersFromFile();
    }


    // REQUIREMENT R3: MEMBER REGISTRATION
    public void registerMember(String username, String password, String fullName) {
        if (!validateUsername(username)) {
            System.out.println("Invalid username. Please try again.");
            return;
        }
        if (!validatePassword(password)) {
            System.out.println("Password must be at least 6 characters long.");
            return;
        }
        if (!validateFullName(fullName)) {
            System.out.println("Full name cannot be empty.");
            return;
        }

        Member newMember = new Member(username, password, fullName);
        members.add(newMember);
        saveMembersToFile();  // Save after registration
    }


    // REQUIREMENT R1: MEMBER LOGIN
    public Member login(String username, String password) {
        for (Member member : members) {
            if (member.getUsername().equals(username) && member.getPassword().equals(password)) {
                return member;
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    }


    // REQUIREMENT R2: MEMBER DATA PERSISTENCE
    private void saveMembersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.txt"))) {
            for (Member member : members) {
                writer.write(member.getUsername() + "," + member.getPassword() + "," + member.getFullName());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving members: " + e.getMessage());
        }
    }

    private void loadMembersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("members.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String username = data[0];
                    String password = data[1];
                    String fullName = data[2];
                    members.add(new Member(username, password, fullName));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading members: " + e.getMessage());
        }
    }

    // Display member information
    public void displayMemberInfo(Member member) {
        if (member != null) {
            member.displayInfo();
        } else {
            System.out.println("No member information available.");
        }
    }


    // MEMBER REGISTRATION INPUT VALIDATION
    private boolean validateUsername(String username) {
        return username != null && !username.trim().isEmpty();
    }

    private boolean validatePassword(String password) {
        return password != null && password.length() >= 6;
    }

    private boolean validateFullName(String fullName) {
        return fullName != null && !fullName.trim().isEmpty();
    }

}
