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

    public List<String> topKFrequentHeap(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
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
