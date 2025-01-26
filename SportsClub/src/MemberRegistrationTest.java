import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MemberRegistrationTest {

    // Unit test for valid member registration inputs
    @Test
    public void testValidMemberRegistration() {
        // Arrange
        String validUsername = "john_doe";
        String validPassword = "password123";
        String validFullName = "John Doe";

        // Act
        boolean isValid = validateMemberInput(validUsername, validPassword, validFullName);

        // Assert
        assertTrue(isValid, "Valid inputs should pass validation.");
    }

    // Unit test for empty username
    @Test
    public void testEmptyUsername() {
        // Arrange
        String emptyUsername = "";
        String validPassword = "password123";
        String validFullName = "John Doe";

        // Act
        boolean isValid = validateMemberInput(emptyUsername, validPassword, validFullName);

        // Assert
        assertFalse(isValid, "Empty username should fail validation.");
    }

    // Unit test for password too short
    @Test
    public void testShortPassword() {
        // Arrange
        String validUsername = "john_doe";
        String shortPassword = "123";
        String validFullName = "John Doe";

        // Act
        boolean isValid = validateMemberInput(validUsername, shortPassword, validFullName);

        // Assert
        assertFalse(isValid, "Password shorter than 6 characters should fail validation.");
    }

    // Unit test for empty full name
    @Test
    public void testEmptyFullName() {
        // Arrange
        String validUsername = "john_doe";
        String validPassword = "password123";
        String emptyFullName = "";

        // Act
        boolean isValid = validateMemberInput(validUsername, validPassword, emptyFullName);

        // Assert
        assertFalse(isValid, "Empty full name should fail validation.");
    }

    // A helper method to simulate the validation logic for member registration
    private boolean validateMemberInput(String username, String password, String fullName) {
        // Username must not be empty
        if (username == null || username.trim().isEmpty()) {
            return false;
        }

        // Password must be at least 6 characters long
        if (password == null || password.length() < 6) {
            return false;
        }

        // Full name must not be empty
        if (fullName == null || fullName.trim().isEmpty()) {
            return false;
        }

        return true;
    }
}
