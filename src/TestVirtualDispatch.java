class Base {
    int foo(String str) {
        return 0;
    }
}

class Derived1 extends Base {
    @Override
    int foo(String str) {
        return 1;
    }
}

class Derived2 extends Base {
    @Override
    int foo(String str) {
        return str.length();
    }
}


public class TestVirtualDispatch {
    public static int testBasic() {
        Base var1 = new Derived1();
        Base var2 = new Derived2();

        int x = var1.foo(null);  // no error
        int y = var2.foo(null);  // error

        return x + y;
    }

    public static int testReassignment(int x) {
        Base var1 = new Derived1();
        var1 = new Derived2();

        return var1.foo(null);
    }

    public static int testUnknownValue(Base var1) {
        return var1.foo(null);
    }
}