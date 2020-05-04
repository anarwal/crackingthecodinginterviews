package bloombergTop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UndergroundSystem {
    // ID --> Time
    HashMap<Integer, Double> entryMap;

    // ID --> Station, Time
    HashMap<Integer, String> checkInMap;

    // StationA-StationB --> Time for each travel
    HashMap<String, ArrayList<Double>> timeMap;

    public UndergroundSystem() {
        entryMap = new HashMap<>();
        checkInMap = new HashMap<>();
        timeMap = new HashMap<>();

    }

    public void checkIn(int id, String stationName, double t) {
        if(!entryMap.containsKey(id)){
            entryMap.put(id, t);
            checkInMap.put(id, stationName);
        }
    }

    // need to add stationNameA, stationNameB, Difference
    public void checkOut(int id, String stationName, double t) {
        ArrayList<Double> durations = timeMap.getOrDefault(checkInMap.get(id)+"-"+stationName, new ArrayList<Double>());

        durations.add(t- (double)entryMap.get(id));
        timeMap.put(checkInMap.get(id)+"-"+stationName, durations);
        timeMap.remove(id);
        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Double> durations = timeMap.get(startStation+"-"+endStation);

        if (durations == null) {
            return -1;
        }

        double sum = 0;

        for (Double duration : durations) {
            sum += duration;
        }

        return sum / durations.size();
    }
}
