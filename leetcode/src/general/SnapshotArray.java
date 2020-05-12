package general;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SnapshotArray {

    Map<Integer, Map<Integer, Integer>> hmap;
    int snapId;

    public SnapshotArray(int length) {
        this.hmap = new HashMap<>();
        this.snapId = 0;
    }

    public void set(int index, int val) {
        Map<Integer, Integer> currentSnapshot = hmap.getOrDefault(snapId, new HashMap<>());
        currentSnapshot.put(index, val);
        hmap.put(snapId, currentSnapshot);
    }

    public int snap() {
        if (!hmap.containsKey(snapId)) {
            hmap.put(snapId, hmap.getOrDefault(snapId - 1, new HashMap<>()));
        }

        Map<Integer, Integer> newSnap = new HashMap<>();
        newSnap.putAll(hmap.get(snapId));

        hmap.put(snapId + 1, newSnap);

        return snapId++;
    }

    public int get(int index, int snap_id) {
        return hmap.get(snap_id).getOrDefault(index, 0);
    }



    public static void main(String[] args) {
        SnapshotArray obj = new SnapshotArray(3);
        obj.set(0, 5);
        System.out.println(obj.snap());
        System.out.println(obj.get(0, 6));
        System.out.println(obj.get(0, 0));
    }
}
