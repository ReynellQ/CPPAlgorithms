/** Computa nCk mod p usando DP */
ll binomial(int n, int k, ll p) {
	vector<vector<ll>> dp(n + 1, vector<ll> (k + 1, 0));
	for (int i = 0; i <= n; i++) {
		dp[i][0] = 1;
		if (i <= k) 
			dp[i][i] = 1; 
	}
	for (int i = 0; i <= n; i++) 
		for (int j = 1; j <= min(i, k); j++) 
			if (i != j) 
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % p;
    /** Puede retornarse el arreglo completo
    con la respuesta de todos los combinatorios desde
    nC0 hasta nCk*/
	return dp[n][k];
}
/** Computa nCk mod p usando factoriales,
que pueden ser precomputados */
ll binomial(int n, int k, ll p) {
    vector<ll> fac = factorial(n, p); //Precomputarse
	vector<ll> inv = inv_factorial(n, p); //Precomputarse
	return fac[n] * inv[k] % p * inv[n - k] % p;
}



