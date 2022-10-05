vector<int> lcp(vector<int> &p, vector<int> &c, string &s){
    int n = p.size();
    vector<int> lcp(n);
    int k = 0;
    for(int i = 0 ; i < n - 1 ; ++i){
        int pi = c[i];
        int j = p[pi - 1];
        while(s[i + k] == s[j + k]) k++;
        lcp[pi] = k;
        k = max(k - 1, 0);
    }
    return lcp;
}