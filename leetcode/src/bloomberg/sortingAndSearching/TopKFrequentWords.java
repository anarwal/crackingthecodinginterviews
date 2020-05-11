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

    public static List<String> topKFrequentHeap(List<String> words, List<String> sentences, int k) {
        Map<String, Integer> count = new HashMap();
        for (int i=0; i<sentences.size(); i++) {
            String[] requests = sentences.get(i).split(" ");
            for(String request: requests){
                if(words.contains(request)){
                    count.put(request, count.getOrDefault(request, 0) + 1);
                }
            }
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ? Integer.compare(w1.length(), w2.length()) : count.get(w1) - count.get(w2));

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
        int m, n, p= 0;
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        List<String> words = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            words.add(scanner.next());
        }

        p = scanner.nextInt();
        List<String> sentences = new ArrayList<>();
        for(int i = 0; i < p; i++) {
            sentences.add(scanner.next());
        }

        topKFrequentHeap(words,sentences, n);
        scanner.close();
    }
}
