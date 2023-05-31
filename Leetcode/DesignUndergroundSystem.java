// url: https://leetcode.com/problems/design-underground-system/

class StationTime {
    String stationName;
    int t;

    StationTime(String stationName, int t) {
        this.stationName = stationName;
        this.t = t;
    }
}

class UndergroundSystem {

    Map<Integer, StationTime> checkedIn;
    Map<String, List<Integer>> map;

    public UndergroundSystem() {
        checkedIn = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if(checkedIn.containsKey(id)) return;
        checkedIn.put(id, new StationTime(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(!checkedIn.containsKey(id)) return;
        StationTime obj = checkedIn.get(id);
        String travel = obj.stationName + "->" + stationName;
        map.putIfAbsent(travel, new ArrayList<>());
        map.get(travel).add(t - obj.t);
        checkedIn.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String travel = startStation + "->" + endStation;
        double sum = 0;
        for(int i: map.get(travel)) sum += (double) i;
        return sum / map.get(travel).size();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
