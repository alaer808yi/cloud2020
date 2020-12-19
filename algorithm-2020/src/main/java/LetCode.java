import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Author     ：jane.
 * @ Date       ：Created in 23:37 2020/6/17
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class LetCode {
    public static void main(String args[]) {
        int[] a = new int[]{1,2,3,9,6};
        twoSum(a,5);

    }

    public static void twoSum(int a[], int twoSum) {
        Map<Integer,Integer[]> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            if(map.get(temp) !=null){
                System.out.println("find:"+temp +"index:"+i+","+map.get(temp)+" is suitable");
            }else{
                Integer store[] = new Integer[2];
                store[0] = temp;
                store[1] = i;
                map.put(twoSum-temp,store);
            }
        }
    }
}
