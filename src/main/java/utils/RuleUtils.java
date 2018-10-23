package utils;

public class RuleUtils {
    public static boolean getResult(String a, String b) {
        a = a.toLowerCase();
        b = a.toLowerCase();
        if (b.contains(a)) {
            return true;
        } else {
            return false;
        }
    }


}
