package technocredits.technoapp.testscripts.standalone;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "Apple");
        map.put("B", "Ball");
        map.put("C", "Cat");
        //HashCode value is 10 for two different keys
//        A -> 10;
//        B -> 10;
//        C -> 10;

        map.get("A");// -> First it will check the hashCode of key,
        // then accordingly choose the bucket, then it will do equals on key to fetch value of exact key
        map.get("B");

        System.out.println(map.size());
    }

}
