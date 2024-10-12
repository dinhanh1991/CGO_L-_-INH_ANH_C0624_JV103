package ss19.bai_tap.phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String CLASS_REGEX ="^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
    public PhoneNumber() {
        pattern = Pattern.compile(CLASS_REGEX);
    }
    public boolean isValid(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
