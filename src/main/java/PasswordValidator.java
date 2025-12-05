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
}
