package com.longjing.springcloud;

import java.util.*;
import java.util.stream.Stream;

/**
 * @ Author     ：jane.
 * @ Date       ：Created in 23:16 2020/8/11
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class Test {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map map = new HashMap();
        String x = "";
        for (int j = 0; j < n; j++) {
            x = sc.next();
            int data = 0;
            if (x.endsWith("T")) {
                data = Integer.valueOf(x.replace("T", ""));
                arr[j] = data * 1000 * 1000;
            } else if (x.endsWith("G")) {
                data = Integer.valueOf(x.replace("G", ""));
                arr[j] = data * 1000;
            } else if (x.endsWith("M")) {
                data = Integer.valueOf(x.replace("M", ""));
                arr[j] = data * 1000;
            }
            map.put(x,arr[j]);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        //升序排序
        Collections.sort(list, (Comparator<Map.Entry<String, Integer>>)
                (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        list.forEach(o ->{
            System.out.println(o.getKey());
        });
    }

//    3
//            1T
//20M
//3G

}
