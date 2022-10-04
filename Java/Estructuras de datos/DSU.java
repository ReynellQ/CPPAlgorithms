static int[]p;
static int N;
static int[]size, rank;
static void init(){
    p = new int[N + 1];
    for(int i = 1 ; i <= N ; ++i){
        p[i] = i; //Algunos requieren p[i] = -1;
        //Inicializar otras caracteristicas del DSU, como size, rank, o acumuladores
        //del conjunto
        size[i] = 1; rank[i] = 0;
    }
}
static int find(int x){
    if(x != p[x])
        return find(p[x]); //return p[x] = find(p[x]) for path compression
    return x;
}
static void union(int x, int y){
    x = find(x); y = find(y);
    if(x == y)
        return;
    //Union simple
    p[x] = y; 
    //Union por tamaño
    if (size[x] < size[y]){
        int aux = x; x = y; y = aux;
    }
    p[x] = y; size[y]+=size[x];
    //Union por rango
    if (rank[x] < rank[y]){
        int aux = x; x = y; y = aux;
    }
    p[x] = y;
    if (rank[x] == rank[y]) rank[y]++;
}