static class ST{
	public int value; // El valor cambia con el problema
	ST l;
	ST r;
	int begin, end, mid;
	ST(int[]arr, int i, int j){
		begin = i; end = j; mid = (i+j)/2;
		if(begin == end)
			value = arr[begin];
		else{
			l = new ST(arr, begin, mid);r = new ST(arr,mid + 1, end);
			this.value = merge(l.value, r.value);
		}
	}
	private int merge(int left, int right){
		//Usar cualquier operación conveniente
	}
	public int query(int i, int j){
		if(i == begin && j == end){
			return value;
		}else{
			if(i <= mid && j <= mid) return l.query(i, j);
			if(i > mid) r.query(i, j); 
			merge(l.query(i, mid), r.query(mid+1, j)); 
		}
	}
	public void update(int a, int i){
		if(begin == end && begin == i)
			value = a;
		else{
			if(i <= mid) l.update(a, i);  
			else r.update(a, i);
			value = merge(l.value, r.value);
		}
	}   
}