# PasswordValidator is a program that validates your password based on certain predefined conditions.

### Conditions:

- The password contains **ATLEAST** 8 Digits
- The password contains **ATLEAST** one Number ( 0-9 )
- The password contains **ATLEAST** one special character
- The password contains **uppercase and lowercase** letters
- The password is not in the predefined list of common passwords

### What do you need to run the code?

- JAVA JDK 25.0.1
- Apache Maven 3.9.11

### How to Test an already existing Password?

1. Clone the repository
2. Find the `isValid_ShoudlReturnTrue_IfPasswordChecks()` Method at the Bottom of the PasswordValidatorTests.java
3. Enter your specifications:
- `pw` -> Enter your password
- `minLength` -> Enter the minimum length of passwords you want to Test
- `maxLength` -> Enter the maximum length of passwords you want to Test
4. Execute the `isValid_ShoudlReturnTrue_IfPasswordChecks()` Method!

### How to generate a secure password & test it

1. Clone the repository
2. Find the `isValid_ShoudlReturnTrue_IfRndmPasswordChecks()` Method at the Bottom of the PasswordValidatorTests.java
3. Enter your desired password length at `pw`
4. Execute the `isValid_ShoudlReturnTrue_IfRndmPasswordChecks()` Method!
