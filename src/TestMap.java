import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static int testBasic() {
        String a = null;
        String b = "not-null";

        Map<Integer, String> map = new HashMap<>();
        map.put(1, a);
        map.put(2, b);

        return map.get(1).length();
    }

    public static int testValueReassignment() {
        String a = null;
        String b = "not-null";

        Map<Integer, String> map = new HashMap<>();
        map.put(1, a);
        map.put(2, b);
        map.put(3, map.get(1));

        return map.get(3).length();
    }

    public static int testMapReassignment() {
        String a = null;

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, a);

        Map<Integer, String> map2 = map1;

        return map2.get(1).length();
    }
}