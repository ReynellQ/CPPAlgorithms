ll lucasBinomial(int n, int k, int p){
    if (k==0)
        return 1;
    int ni = n%p, ki = k%p;
    return (lucasBinomial(n/p, k/p, p) * binomial(ni, ki, p)) % p; 
}