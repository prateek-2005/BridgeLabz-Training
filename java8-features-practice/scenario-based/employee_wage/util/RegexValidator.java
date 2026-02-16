package util;

import java.util.regex.Pattern;

public class RegexValidator {

    private static final String COMPANY_REGEX =
            "^[A-Z][a-zA-Z]{2,}$";

    public static boolean
    validateCompany(String name) {

        return Pattern.matches(
                COMPANY_REGEX,
                name);
    }
}
