import java.util.function.Function;

public class TestLambdas {
    public static int testPropagationThroughLambda() {
        String a = null;
        Function<String, String> f = (x) -> x;

        String b = f.apply(a);

        return b.length();
    }

    public static int testPropagationThroughLambda2() {
        String a = "not-null";
        Function<String, String> f = (x) -> x == null ? "not-null" : null;

        String b = f.apply(a);
        return b.length();
    }

    public static int testPropagationThroughConditionalLambda(boolean condition) {
        String a = "not-null";

        Function<String, String> f1 = (x) -> x;
        Function<String, String> f2 = (x) -> x == null ? "not-null" : null;
        Function<String, String> f = condition ? f1 : f2;

        String b = f.apply(a);
        return b.length();
    }

    public static int testPropagationThroughConditionalLambda2(boolean condition) {
        String a = null;

        Function<String, String> f1 = (x) -> x;
        Function<String, String> f2 = (x) -> x == null ? "not-null" : null;
        Function<String, String> f = condition ? f1 : f2;

        String b = f.apply(a);
        return b.length();
    }
}