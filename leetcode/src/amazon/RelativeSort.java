package amazon;

import java.util.*;

public class RelativeSort {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i: arr1){
            hmap.put(i, hmap.getOrDefault(i, 0)+1);
        }
        int[] result = new int[arr1.length];
        int current =0;
        for(int j : arr2){
            if(hmap.containsKey((j))){
                int count = hmap.get(j);
                while(count !=0){
                    result[current] = j;
                    current++;
                    count--;
                }
                hmap.remove(j);
            }
        }

        for(int k:arr1){
            if(hmap.containsKey(k)){
                result[current] = k;
                current++;
            }
        }
        return result;
    }

    public static void main(String[] main) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] arr1 = new int[m];
        int[] arr2 = new int[n];

        for(int i=0; i<m;i++){
           arr1[i] =scanner.nextInt();
        }
        for(int j=0; j<n;j++){
            arr2[j] = scanner.nextInt();
        }
        int[] result = relativeSortArray(arr1, arr2);
        System.out.print(result);
        scanner.close();
    }
}
