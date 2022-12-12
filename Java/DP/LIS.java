public static int solve() {
    ArrayList<Integer> dp = new ArrayList<Integer>();
    for (int i : a) {
        int pos = binarySearch(dp, i);
        if (pos >= dp.size()) {
            dp.add(i);
        } else {
            dp.set(pos, i);
        }
    }
    return dp.size();
}
static int binarySearch(ArrayList<Integer> dp, int x){
    int l = 0, r = dp.size() - 1, mid;
    while(l <= r){
        mid = (l + r + 1)/2;
        if(dp.get(mid) < x)
            l = mid + 1;
        else
            r = mid - 1;
    }
    return l;
}