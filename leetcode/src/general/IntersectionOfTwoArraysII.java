package general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hmap.put(nums1[i], i);
        }

        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums2.length; j++) {
            if (hmap.containsKey(nums2[j])) {
                list.add(nums2[j]);
                hmap.remove(nums2[j]);
            }
        }
        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            result[k] = list.get(k);
        }
        return result;
    }
}
