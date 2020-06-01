package general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hset = new HashSet<>();
        for(int i=0; i<nums1.length; i++){
            if(hset.contains(nums1[i])) continue;
            else hset.add(nums1[i]);
        }
        int len = nums1.length>nums2.length ? nums1.length:nums2.length;
        List<Integer> alist = new ArrayList<>();
        for(int j=0; j<nums2.length; j++){
            if(hset.contains(nums2[j])){
                if(!alist.contains(nums2[j])){
                    alist.add(nums2[j]);
                }
            }
        }
        int[] result = new int[alist.size()];
        int k=0;
        for(Integer i:alist){
            result[k] = i;
            k++;
        }
        return result;
    }
}
