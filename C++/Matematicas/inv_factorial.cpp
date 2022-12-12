vector<ll> inv_factorial(ll N, ll p) {
    vector<ll> invf(N + 1);
    vector<ll> fac = factorial(N, p); //Precomputarse
	invf[N] = inv(fac[N], p);
	for (int i = N; i >= 1; i--) {
		invf[i - 1] = invf[i] * i % p;
	}
    return invf;
}