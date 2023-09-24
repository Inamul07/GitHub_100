// url: https://leetcode.com/problems/champagne-tower/

class Glass {
    double filled, extra;

    Glass() {
        filled = 0.0;
        extra = 0.0;
    }

    public void pour(double val) {
        filled += val;
        if(filled > 1.0) {
            extra += filled - 1;
            filled = 1;
        }
    }
}

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<List<Glass>> list = new ArrayList<>();
        for(int i = 0; i <= query_row; i++) {
            List<Glass> row = new ArrayList<>();
            for(int j = 0; j < i+1; j++) {
                Glass glass = new Glass();
                if(i == 0) glass.pour((double) poured);
                if(j != i) glass.pour((list.get(i-1).get(j).extra) / 2.0);
                if(j != 0) glass.pour((list.get(i-1).get(j-1).extra) / 2.0);
                row.add(glass);
            }
            list.add(row);
        }
        return list.get(query_row).get(query_glass).filled;
    }
}
