pair<ll,ll> extend_euclid(ll a, ll b) {  // returns {x,y}, for gcd do ax + by
	if (b == 0) 
		return {1, 0};
	pl p = extend_euclid(b, a % b); 
	return {p.s, p.f - a / b * p.s};
}