vector<ll> factorial(ll N, ll p) {
	vector<ll> fac(N + 1);
    fac[0] = 1;
	for (int i = 1; i <= N; i++) 
		fac[i] = fac[i - 1] * i % p;
	return fac;
}