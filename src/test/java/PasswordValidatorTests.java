import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions .*;

public class PasswordValidatorTests {

    // hasLength TEST

    @Test
    public void hasLength_ShouldReturnTrue_IfLengthIsMin() {
        String pw = "TestLol1";
        int minLength = 8;
        int maxLength = 32;
        assertTrue(PasswordValidator.hasLength(pw, minLength, maxLength));
    }

    @Test
    public void hasLength_ShouldReturnTrue_IfLengthIsMax() {
        String pw = "vH39KpA7mQw24ZsL8tR1yNfGkB0cXd1u";
        int minLength = 8;
        int maxLength = 32;
        assertTrue(PasswordValidator.hasLength(pw, minLength, maxLength));
    }

    @Test
    public void hasLength_ShouldReturnTrue_IfLengthIsAboveMin() {
        String pw = "TestLol12";
        int minLength = 8;
        int maxLength = 32;
        assertTrue(PasswordValidator.hasLength(pw, minLength, maxLength));
    }

    @Test
    public void hasLength_ShouldReturnFalse_IfLengthIsBelowMin() {
        String pw = "TestLol";
        int minLength = 8;
        int maxLength = 32;
        assertFalse(PasswordValidator.hasLength(pw, minLength, maxLength));
    }

    @Test
    public void hasLength_ShouldReturnFals_IfLengthIsAboveMax() {
        String pw = "vH39KpA7mQw24ZsL8tR1yNfGkB0cXd1u11a";
        int minLength = 8;
        int maxLength = 32;
        assertFalse(PasswordValidator.hasLength(pw, minLength, maxLength));
    }

    // containsDigit TESTS

    //@Test
    //public void containsDigit_ShouldReturnTrue_IfOneDigit() {
    //    String pw = "TestLol1";
    //    assertTrue(PasswordValidator.containsDigit(pw));
    //}

    //@Test
    //public void containsDigit_ShouldReturnTrue_IfMultipleDigit() {
    //    String pw = "TestLol123";
    //    assertTrue(PasswordValidator.containsDigit(pw));
    //}

    @Test
    public void containsDigit_ShouldReturnFalse_IfNoDigit() {
        String pw = "TestLol";
        assertFalse(PasswordValidator.containsDigit(pw));
    }

    @Test
    public void containsDigit_ShouldReturnFalse_IfOnlyDigits() {
        String pw = "1243763";
        assertFalse(PasswordValidator.containsDigit(pw));
    }

    // containsUpperAndLower TESTS

    @Test
    public void containsUpperAndLower_ShouldReturnFalse_IfOnlyUpper() {
        String pw = "HALLO";
        assertFalse(PasswordValidator.containsUpperAndLower(pw));
    }

    @Test
    public void containsUpperAndLower_ShouldReturnFalse_IfOnlyLower() {
        String pw = "hallo";
        assertFalse(PasswordValidator.containsUpperAndLower(pw));
    }

    @Test
    public void containsUpperAndLower_ShouldReturnTrue_IfUpperAndLower() {
        String pw = "Hallo";
        assertTrue(PasswordValidator.containsUpperAndLower(pw));
    }

    //isCommonPassword

    @Test
    public void isCommonPassword_ShouldReturnFals_IfPasswordIsCommon() {
        String pw = "12345678";
        assertTrue(PasswordValidator.isCommonPassword(pw));
    }

    //checkBlanks

    @Test
    public void checkBlanks_ShouldReturnTrue_IfPasswordStartsWithBlank() {
        String pw = " Test123";
        assertTrue(PasswordValidator.checkBlanks(pw));
    }

    @Test
    public void checkBlanks_ShouldReturnTrue_IfPasswordEndsWithBlank() {
        String pw = "Test123 ";
        assertTrue(PasswordValidator.checkBlanks(pw));
    }

    // isValid

    @Test
    public void isValid_ShoudlReturnTrue_IfPasswordChecks() {
        String pw = "TestLol123";
        int minLength = 8;
        int maxLength = 32;
        assertTrue(PasswordValidator.isValid(pw, minLength, maxLength));
    }
}
