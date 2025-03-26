class Obj {
    String field = "Obj.field";
}

public class TestAliasing {
    public static int testBasic() {
        Obj a = new Obj();
        Obj b = a;
        a.field = null;

        return b.field.length();
    }

    public static int testConditionalAssignment(boolean condition) {
        Obj a = new Obj();
        Obj b = new Obj();
        Obj c;

        if (condition) {
            c = a;
        } else {
            c = b;
        }
        a.field = null;

        return c.field.length();
    }
}