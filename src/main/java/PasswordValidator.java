import java.security.SecureRandom;

public class PasswordValidator {
    public static boolean hasLength(String pw, int minLength, int maxLength) {

        int Length = pw.length();

        if (Length >= minLength && Length <= maxLength) {
            return true;
        } else
            return false;
    }

    public static boolean containsDigit(String pw) {

        char[] pwChar = pw.toCharArray();
        int amount = 0;

        for(char value : pwChar ) {
            if (Character.isDigit(value)) {
                amount++;
            }
        }

        if(amount >= 1 && amount != pw.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean containsUpperAndLower(String pw) {
        char[] pwChar = pw.toCharArray();
        int amountUpper = 0;
        int amountLower = 0;

        for(char value : pwChar ) {
            if (Character.isUpperCase(value)) {
                amountUpper++;
            } else if (Character.isLowerCase(value)) {
                amountLower++;
            }
        }

        if(amountUpper > 0 && amountLower > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isCommonPassword(String pw) {

        String[] commonPw = new String[] {"password", "Passwort1", "12345678"};
        boolean common = false;

        for(String value : commonPw) {
            if (value.equals(pw)) {
                common = true;
            }
        }
        return common;
    }

    public static boolean checkBlanks(String pw) {

        boolean hasLeading = pw.startsWith(" ");
        boolean hasEnding = pw.endsWith(" ");

        return hasLeading || hasEnding;
    }

    public static boolean containsSpecialCharacter(String pw) {

        for(char value : pw.toCharArray()) {
            if(!Character.isLetterOrDigit(value)) {
                return true;
            }
        }
        return false;
    }

    public static String rndmPw(int length) {

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specials = "!?#";
        SecureRandom rndm = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        password.append(upper.charAt(rndm.nextInt(upper.length())));
        password.append(lower.charAt(rndm.nextInt(lower.length())));
        password.append(digits.charAt(rndm.nextInt(digits.length())));
        password.append(specials.charAt(rndm.nextInt(specials.length())));

        String allChars = upper + lower + digits + specials;
        for(int i = 4; i < length; i++) {
            password.append(allChars.charAt(rndm.nextInt(allChars.length())));
        }

        for (int i = 0; i < password.length(); i++) {
            int rndmIndex = rndm.nextInt(password.length());
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(rndmIndex));
            password.setCharAt(rndmIndex, temp);
        }

        return password.toString();
    }

    public static boolean isValid(String pw, int minLength, int maxLength) {

        if(pw == null) {
            return false;
        }

        boolean valiLength = hasLength(pw, minLength, maxLength);
        boolean validDigits = containsDigit(pw);
        boolean validUpAndLow = containsUpperAndLower(pw);
        boolean commonPw = isCommonPassword(pw);
        boolean validBlanks = checkBlanks(pw);
        boolean validSpecialCharacter = containsSpecialCharacter(pw);

        return valiLength && validDigits && validUpAndLow && !commonPw && !validBlanks && validSpecialCharacter;
    }

    public static boolean isRndmValid(String pw) {

        if(pw == null) {
            return false;
        }

        boolean validDigits = containsDigit(pw);
        boolean validUpAndLow = containsUpperAndLower(pw);
        boolean commonPw = isCommonPassword(pw);
        boolean validBlanks = checkBlanks(pw);
        boolean validSpecialCharacter = containsSpecialCharacter(pw);

        return validDigits && validUpAndLow && !commonPw && !validBlanks && validSpecialCharacter;
    }
}
