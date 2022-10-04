static final Random rand=new Random(5);
static class Treap {
	int data, priority, size;
	Treap l, r;
	public Treap(int data) { this(data, rand.nextInt()); }
	public Treap(int data, int priority) {
		this.data=data;
		this.priority = priority;
		this.size = 1;
	}	
	static Treap[] split(Treap t, int data){
		Treap[]s;
		if(t == null) return new Treap[] {null, null};
		if(t.data <= data){
			s=split(t.r, data);
			t.r=s[0];
			upd_size(t); upd_size(s[1]);
			return new Treap[] {t, s[1]};
		}else{
			s=split(t.l, data);
			t.l=s[1];
			upd_size(s[0]); upd_size(t);
			return new Treap[] {s[0], t};
		}
	}
	static Treap merge (Treap t, Treap it) {
		if (t==null) return it;
		if (it==null) return t;
		if ( it.priority > t.priority){
			Treap[]s = Treap.split(t, it.data);
			it.l = s[0]; it.r = s[1]; Treap.upd_size(it);
			return it;
		}else{
			if(t.data <= it.data) t.r = Treap.merge(t.r, it);
			else t.l = Treap.merge(t.l, it);
			Treap.upd_size(t);
			return t;
		}
	}
	static Treap unite (Treap l, Treap r) {
		if(l == null) return r;
		if(r == null) return l;
		Treap L, R;
		if (l.priority < r.priority){
			L = r; R = l;
		}else{
			L = l; R = r;
		}
		Treap[]s = split (R, L.data);
		Treap u = new Treap(L.data, L.priority);
		u.l = unite (L.l, s[0]);  u.r = unite (L.r, s[1]);
		Treap.upd_size(u);
		return u;
	}
	static int size(Treap t){ return t != null ? t.size : 0; }
	static void upd_size(Treap t){
		if(t!=null) t.size = size(t.l) + size(t.r) + 1;
	}
}