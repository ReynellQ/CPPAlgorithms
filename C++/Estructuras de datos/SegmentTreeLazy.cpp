const int MAXN = 100000;
ll ST[4*MAXN];
ll lazy[4*MAXN];
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
    lazy[node] = 0;
}

void propagate(int node, int start, int end){
    if(lazy[node]){
        ST[node]+=(end- start +  1)*lazy[node];
        if (start != end){
            lazy[node*2     ]+= lazy[node];
            lazy[node*2 + 1 ]+= lazy[node];
        }
        lazy[node] = 0;
    }
}
ll query(int node, int start, int end, int l, int r){
    propagate(node, start, end);
    if (start > r || end < l) 
        return 0;
    if (start >= l && end <= r) 
        return ST[node];
    int mid = (start + end) / 2;
    ll op1 = query(2 * node    , start  , mid, l, r);
    ll op2 = query(2 * node + 1, mid + 1, end, l, r);
    return comb(op1, op2);
}

void update_range(int node, int start, int end, int l, int r, int x){
    propagate(node, start, end);
    if (start > r || end < l) 
        return;
    if (start >= l && end <= r){
        ST[node] += (end-start+1)*x;
        if (start != end) {
            lazy[2*node    ]+= x;
            lazy[2*node + 1]+= x;
        }
        return;
    }
    int mid = (start + end) / 2;
    update_range(2*node     , start, mid, l, r, x);
    update_range(2*node + 1 , mid+1, end, l, r, x);
    ST[node] = comb(ST[2*node], ST[2*node + 1]);
}