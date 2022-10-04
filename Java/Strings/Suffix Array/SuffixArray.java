static int[]p, c;
public static class Suffix implements Comparable<Suffix> {
    int index, r, next;
    public Suffix(int index, int rank, int next){
        this.index = index; this.r = rank; this.next = next;
        }
    public int compareTo(Suffix s){
        return r != s.r ? r - s.r : (next != s.next ? next - s.next : index - s.index);
    }
}
public static int[] sort(int[] p, int[]c){
    int N = p.length;
    int[]cnt = new int[N], pos = new int[N], p_new = new int[N];;
    for(int e : c)  cnt[e]++;
        for(int i = 1 ; i < N ; ++i) pos[i] = pos[i - 1] + cnt[i - 1];
        for(int x : p){
            p_new[pos[c[x]]] = x; pos[c[x]]++;
        }
        p = p_new;
        return p;
    }
public static int[] suffixArray(String s) {
    s+="$";
    int n = s.length();
    c = new int[n];
    p = new int[n];
    Suffix[] su = new Suffix[n];
    for (int i = 0; i < n; ++i) su[i] = new Suffix(i, s.charAt(i), 0);
    Arrays.sort(su);
    for(int i = 0 ; i < n ; ++i) p[i] = su[i].index;
    c[p[0]] = 0;
    for(int i = 1 ; i < n ; ++i) c[p[i]] = su[i].r == su[i - 1].r ?c[ p[i-1]] :c[p[i-1]] + 1;
    int k = 0, shift;
    while((1<<k) < n){
        shift = (1<<k);
        for(int i = 0 ; i < n ; ++i) p[i] = (p[i] - shift + n ) % n;
        p = sort(p, c);
        int[] c_new = new int[n];
        c_new[p[0]] = 0;      
        for(int i = 1 ; i < n ; ++i)
            c_new[p[i]] = (c[p[i]] == c[p[i-1]] && c[(p[i]+shift) % n ] == c[(p[i - 1] + shift) % n]) 
                        ? c_new[p[i - 1]] : c_new[p[i - 1]] + 1;
        c = c_new;
        ++k;
    }
    return p;
}