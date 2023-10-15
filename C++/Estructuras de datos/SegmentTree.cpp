const int MAXN = 100000;
ll ST[4*MAXN];
const int ROOT = 1;

ll comb(ll left, ll right){
    return left + right;
}

void buildSegTree(vector<ll>&arr, int l, int r, int node){
    if(l == r){
        ST[node] = arr[l];
        return;
    }
    int m = (l + r )/2;
    buildSegTree(arr, l, m, 2*node);
    buildSegTree(arr, m + 1, r, 2*node + 1);
    ST[node] = comb(ST[2*node], ST[2*node + 1]);
}


ll query(int node, int start, int end, int l, int r){
    if (start > r || end < l) 
        return 0;
    if (start >= l && end <= r) 
        return ST[node];
    int mid = (start + end) / 2;
    ll op1 = query(2 * node    , start  , mid, l, r);
    ll op2 = query(2 * node + 1, mid + 1, end, l, r);
    return comb(op1, op2);
}

void update(int node, int start, int end, int x, int i){
    if (i < start || i > end)
        return;
    if (start != end){
        int mid = (start + end) / 2;
        update(2*node    , start, mid, x, i);
        update(2*node + 1, mid+1, end, x, i);
        ST[node] = comb(ST[2*node], ST[2*node + 1]);
    }else{
        ST[node] = x;
    }
}