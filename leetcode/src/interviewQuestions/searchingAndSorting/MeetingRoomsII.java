package interviewQuestions.searchingAndSorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {

        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        if (intervals.length == 0 || intervals == null) return 0;
        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));

        LinkedList<int[]> list = new LinkedList<>();

        int counter = 0;

        for(int i=0; i<intervals.length; i++){
            if(list.isEmpty() || list.getLast()[1] < intervals[i][0]){
                list.addLast(intervals[i]);
                continue;
            }else{

                counter++;
            }
        }
        return counter;
    }
}
