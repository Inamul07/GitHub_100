// url: https://leetcode.com/problems/product-of-the-last-k-numbers/

class ProductOfNumbers {

    List<Long> prod;
    int lastZeroIdx;
    int len;

    public ProductOfNumbers() {
        prod = new ArrayList<>();
        lastZeroIdx = -1;
        len = 0;
    }
    
    public void add(int num) {
        if(num == 0) lastZeroIdx = len;
        if(prod.size() == 0 || lastZeroIdx == len-1) prod.add((long) num);
        else prod.add(prod.get(len-1) * (long) num);
        len++;
    }
    
    public int getProduct(int k) {
        int r = len-1, l = len - 1 - k;
        if(lastZeroIdx > l) return 0;
        long lastPro = prod.get(r);
        if(l < 0 || prod.get(l) == 0) return (int) lastPro;
        return (int) (lastPro / prod.get(l));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
