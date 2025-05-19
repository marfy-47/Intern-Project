package com.example.Appointment.System.Validation;

import java.util.regex.Pattern;

public class Validation {

    // Regex for email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    // Regex for Bangladeshi phone numbers
    private static final String BD_PHONE_REGEX = "^(\\+8801|8801|01)[3-9][0-9]{8}$";

    // Regex for strong password (min 8 chars, 1 upper, 1 lower, 1 digit, 1 special char)
    private static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern BD_PHONE_PATTERN = Pattern.compile(BD_PHONE_REGEX);
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidBDPhone(String phone) {
        return phone != null && BD_PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isValidPassword(String password) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }
}
