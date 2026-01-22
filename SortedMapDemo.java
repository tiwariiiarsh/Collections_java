import java.util.SortedMap;
import java.util.TreeMap;

import java.util.NavigableMap;


public class SortedMapDemo {
    public static void main(String[] args) {
        SortedMap<Integer, String> map = new TreeMap<>((a, b) -> b - a);
        map.put(91, "Vivek");
        map.put(99, "Shubham");
        map.put(78, "Mohit");
        map.put(77, "Vipul");
        map.get(77);
        map.containsKey(78);
        map.containsValue(77);


//        System.out.println(map);
//        System.out.println(map.firstKey());
//        System.out.println(map.lastKey());
//        System.out.println(map.headMap(91)); // exclude
//        System.out.println(map.tailMap(91));

        NavigableMap<Integer, String> navigableMap =  new TreeMap<>();
        navigableMap.put(1, "One");
        navigableMap.put(5, "Five");
        navigableMap.put(3, "Three");
        System.out.println(navigableMap);
        System.out.println(navigableMap.lowerKey(4));
        System.out.println(navigableMap.ceilingKey(3));
        System.out.println(navigableMap.higherEntry(1));
        System.out.println(navigableMap.descendingMap());
    }
}











//---------->>>  Sorted using comparator in TreeMap <<<----------------

//class Student {
//    int id;
//    String name;
//
//    Student(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return id + "-" + name;
//    }
//}
//


//public class Main {
//    public static void main(String[] args) {
//
//        SortedMap<Student, Integer> map =
//                new TreeMap<>((s1, s2) -> s2.id - s1.id);
//
//        map.put(new Student(101, "Arsh"), 90);
//        map.put(new Student(103, "Rahul"), 85);
//        map.put(new Student(102, "Neha"), 88);
//
//        System.out.println(map);
//    }
//}
//--------o/p---------------
//{103-Rahul=85, 102-Neha=88, 101-Arsh=90}

//✅----------- Safer version (id same ho to name compare)-----------
//new TreeMap<>((s1, s2) -> {
//        if (s1.id != s2.id)
//        return s2.id - s1.id;
//    return s1.name.compareTo(s2.name);
//});



//------------>>> sorting using comparable in TreeMap <<<------------------
//
//class Student implements Comparable<Student> {
//
//    int id;
//    String name;
//
//    Student(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    @Override
//    public int compareTo(Student s) {
//        // DESCENDING order by id
//        return s.id - this.id;
//    }
//
//    @Override
//    public String toString() {
//        return id + "-" + name;
//    }
//}


//public class Main {
//    public static void main(String[] args) {
//
//        SortedMap<Student, Integer> map = new TreeMap<>();
//
//        map.put(new Student(101, "Arsh"), 90);
//        map.put(new Student(103, "Rahul"), 85);
//        map.put(new Student(102, "Neha"), 88);
//
//        System.out.println(map);
//    }
//}

//Output (DESC by Student id)
//{103-Rahul=85, 102-Neha=88, 101-Arsh=90}

//✅----------- Safer version (id same ho to name compare)-----------
//@Override
//public int compareTo(Student s) {
//    if (this.id != s.id)
//        return s.id - this.id;   // DESC
//    return this.name.compareTo(s.name);
//}