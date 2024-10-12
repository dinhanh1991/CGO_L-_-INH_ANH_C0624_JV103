package ss19.bai_tap.class_validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClass {
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String CLASS_REGEX = "^[CAP]\\d{4}[GHIK]$";
    public NameClass() {
        pattern = Pattern.compile(CLASS_REGEX);
    }
    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
