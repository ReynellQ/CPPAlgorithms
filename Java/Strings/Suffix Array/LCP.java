static int[]p, c, LCP;

static int[] lcp(int[] p, int[]c, String s){
    int n = p.length;
    LCP = new int[n];
    int k = 0;
    for(int i = 0 ; i < n - 1 ; ++i){
        int pi = c[i];
        int j = p[pi - 1];
        while(s.charAt(i + k) == s.charAt(j + k)) k++;
        LCP[pi] = k;
        k = Math.max(k - 1, 0);
    }
    return LCP;
}