/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package share.utils;

/**
 *
 * @author Asus
 */
public class PhoneNumberUtils {
public static boolean checkPhoneNumber(String phoneNumber) {
    if (phoneNumber == null || phoneNumber.length() != 10) {
        return false;
    }

    if (!phoneNumber.matches("\\d+")) {
        return false;
    }

    String[] validPrefixes = {"03", "05", "07", "08", "09"};
    String prefix = phoneNumber.substring(0, 2);
    for (String validPrefix : validPrefixes) {
        if (prefix.equals(validPrefix)) {
            return true;
        }
    }

    return false;
}
}
