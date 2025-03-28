public class TestStringIndexing {
    public static void testBasic() {
        // Adapted from OWASP BenchmarkTest01252
        String a = null;
        String b = "not-null";
        int result = 0;

        String guess = "ABC";
        char switchTarget = guess.charAt(1);  // = 'B'

        switch (switchTarget) {
            case 'A':
                result += a.length();  // unreachable
                break;
            case 'B':
                result += b.length();  // no error
                break;
            case 'C':
            case 'D':
                result += a.length();  // unreachable
                break;
            default:
                break;
        }
    }

    public static void testBasic2() {
        // Adapted from OWASP BenchmarkTest01252
        String a = null;
        String b = "not-null";
        int result = 0;

        String guess = "ABC";
        char switchTarget = guess.charAt(1);  // = 'B'

        switch (switchTarget) {
            case 'A':
                result += b.length();  // unreachable
                break;
            case 'B':
                result += a.length();  // error
                break;
            case 'C':
            case 'D':
                result += b.length();  // unreachable
                break;
            default:
                break;
        }
    }

    public static void testUnknownIndex(int index) {
        // Adapted from OWASP BenchmarkTest01252
        String a = null;
        String b = "not-null";
        int result = 0;

        String guess = "ABC";
        char switchTarget = guess.charAt(index);

        switch (switchTarget) {
            case 'A':
                result += a.length();  // error
                break;
            case 'B':
                result += b.length();  // no error
                break;
            case 'C':
            case 'D':
                result += a.length();  // error
                break;
            default:
                break;
        }
    }

    public static void testUnknownString(String letters) {
        // Adapted from OWASP BenchmarkTest01252
        String a = null;
        String b = "not-null";
        int result = 0;

        char switchTarget = letters.charAt(1);

        switch (switchTarget) {
            case 'A':
                result += a.length();  // error
                break;
            case 'B':
                result += b.length();  // no error
                break;
            case 'C':
            case 'D':
                result += a.length();  // error
                break;
            default:
                break;
        }
    }
}