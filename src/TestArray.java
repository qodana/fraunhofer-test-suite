import java.util.ArrayList;

import static java.util.Collections.rotate;

public class TestArray {
    public static int testBasic() {
        String a = null;
        String b = "not-null";

        ArrayList<String> arr = new ArrayList<>();
        arr.add(a);
        arr.add(b);
        arr.add(b);
        arr.add(a);

        return arr.get(3).length();
    }

    public static int testValueReassignment() {
        String a = null;
        String b = "not-null";

        ArrayList<String> arr = new ArrayList<>();
        arr.add(a);
        arr.add(b);
        arr.add(a);
        arr.add(b);
        arr.set(1, arr.get(0));
        arr.set(2, arr.get(3));

        int x = arr.get(1).length();  // error
        int y = arr.get(2).length();  // no error
        return x + y;
    }

    public static int testArrayTransformation() {
        String a = null;
        String b = "not-null";

        ArrayList<String> arr = new ArrayList<>();
        arr.add(a);
        arr.add(b);
        arr.add(b);
        arr.add(a);

        rotate(arr, 1);

        int x = arr.get(1).length();  // error
        int y = arr.get(3).length();  // no error
        return x + y;
    }
}