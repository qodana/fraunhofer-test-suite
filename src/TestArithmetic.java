public class TestArithmetic {
    public static int testBasic() {
        String a = null;
        String b = "not-null";

        if (2 + 2 == 4) {
            b = a;
        }

        return b.length();
    }

    public static int testUnknownValue(int x) {
        String a = null;
        String b = "not-null";

        if (x > 0) {
            b = a;
        }

        return b.length();
    }

    public static int testValueRange(int x) {
        if (x < 0 || x > 10) return 0;

        String a = null;
        int result = 0;

        if (x == 5) {
            result += a.length();  // error
        }

        if (x == 100) {
            result += a.length();  // no error
        }

        return result;
    }
}