package statics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo {
    private static String name = "demo";

    public static void main(String[] args) {
        List<String> names = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
        }};
        List<String> subList = names.subList(0, 1);
        ArrayList<String> subCopyList = new ArrayList<>(subList);
        subList.add("4");
        subCopyList.add("5");
        System.out.println(subList);
        System.out.println(subCopyList);
        System.out.println(names);

        names.add("6");
        System.out.println(names);
        System.out.println(subList);
    }
}
