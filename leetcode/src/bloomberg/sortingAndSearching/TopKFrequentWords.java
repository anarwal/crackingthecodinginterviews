package bloomberg.sortingAndSearching;

import java.util.*;


public class TopKFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hmap = new HashMap<>();

        for(String s : words){
            if(hmap.containsKey(s)){
                hmap.put(s, hmap.get(s)+1);
            }else{
                hmap.put(s, 1);
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return hmap.get(o1).equals(hmap.get(o2)) ? o1.compareTo(o2) : hmap.get(o2) - hmap.get(o1);
            }
        });

        sortedMap.putAll(hmap);
        List<String> alist = new ArrayList<>();

        for(Map.Entry me: sortedMap.entrySet()){
            if(k>0){
                alist.add(me.getKey().toString());
                k--;
            }
            else break;
        }
        return alist;
    }

    public static void main(String[] args){
        int m, n = 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        String arr[] = new String[m];
        for(int i = 0; i < m; i++) {
            arr[i] =scanner.next();
        }
        topKFrequent(arr, n);
        scanner.close();
    }
}
