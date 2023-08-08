package common.string;

import java.lang.reflect.Field;
import java.util.concurrent.CopyOnWriteArrayList;

public class StringDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        String s = new String("abc");
//        s = s.replace("abc", "abcd");
//        Field value = s.getClass().getDeclaredField("value");
//        value.setAccessible(true);
//        value.set(s, "abcd".toCharArray());
//        System.out.println(s);

        String s1 = new String("abc");
        String s2 = "abc";
        System.out.println(s1 == s2);
        String s3 = s1.intern();
        System.out.println(s2==s3);
        System.out.println(s1==s3);

        Integer i1=100;
        Integer i2=100;
        System.out.println(i1==i2);
        Integer i3=128;
        Integer i4=128;
        System.out.println(i3==i4);

        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
    }
}
