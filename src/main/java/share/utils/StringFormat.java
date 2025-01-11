/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package share.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Asus
 */
public class StringFormat {
    public static String formatCurrencyVND(float amount) {
        // Sử dụng Locale cho Việt Nam
        Locale vietnam = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnam);

        return currencyFormatter.format(amount);
    }
}
