const ll MAX = 1000000000000000000; // 10^18

struct edge{
  int x, y;
  ll w;
};

int n;
vector<ll> s;
vector<edge> edges;

void bellman(){
  FOR(i, 1, n){  // Relax n - 1 times
    for(const edge &e: edges){
      if(s[e.x] == MAX) continue;
      s[e.y] = min(s[e.y], s[e.x] + e.w);
      s[e.y] = max(-MAX, s[e.y]);
    }
  }

  FOR(i, 1, n){ // Deal with all neg cycles.
    for(const edge &e: edges){
      if(s[e.x] == MAX) continue;
      s[e.y] = max(-MAX, s[e.y]);
      if(s[e.x] + e.w < s[e.y]) s[e.y] = -MAX;
    }
  }
}