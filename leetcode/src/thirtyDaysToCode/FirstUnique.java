package thirtyDaysToCode;

import java.util.*;

public class FirstUnique {
    HashMap<Integer, Integer> hmap = new HashMap<>();
    Set<Integer> set = new LinkedHashSet<>();

    public FirstUnique(int[] nums) {
        for(int i=0; i<nums.length; i++){
           add(nums[i]);
        }
    }

    public int showFirstUnique() {
        return set.isEmpty() ? -1: set.iterator().next();
    }

    public void add(int value) {
        hmap.put(value, hmap.getOrDefault(value, 0)+1);
        if(hmap.get(value) ==1) { set.add(value);}
        else set.remove(value);
    }

    public static void main(String[] args){
        int m = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        int nums[] = new int[m];
        for(int i = 0; i < m; i++) {
            nums[i] =scanner.nextInt();
        }
        FirstUnique obj = new FirstUnique(nums);
        System.out.print(obj.showFirstUnique());
        obj.add(5);
        System.out.print(obj.showFirstUnique());
        obj.add(2);
        System.out.print(obj.showFirstUnique());
        obj.add(3);
        System.out.print(obj.showFirstUnique());
    }
}
