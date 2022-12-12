ll euclid(ll a, ll b) {
	return (b == 0) ? a : euclid(b, a % b);
}