//Usando binpow
ll inv(ll a, ll mod){
  ll n = mod - 2;
  ll ans = binpow(a, n, mod);
  return ans;
}
//Usando euclides extendido
ll inv(ll a, ll b) {
	pair<ll,ll> x = extend_euclid(a, b);
	ll ans = x.first + (x.first < 0) * b;
	return ans;
}
