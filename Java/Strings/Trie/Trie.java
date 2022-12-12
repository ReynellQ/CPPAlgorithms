class Trie{
    int alph = 26;
    Trie[] sons;
    int words;
    boolean finalWord;
    public Trie(){
        sons = new Trie[alph];
        words = 0;
        finalWord = false;
    }
    public void addWord(String s){
        Trie aux = this;
        aux.words++;
        for(int i = 0 ; i < s.length() ; ++i){
            if(aux.sons[s.charAt(i) - 'a'] == null){
                aux.sons[s.charAt(i) - 'a'] = new Trie();
            }
            aux = aux.sons[s.charAt(i) - 'a'];
            aux.words++;
        }
        aux.finalWord = true;
    }
    public int countWords(String s){
        Trie aux = this;
        for(int i = 0 ; i < s.length() ; ++i){
            if(aux.sons[s.charAt(i) - 'a'] == null){
                return 0;
            }
            aux = aux.sons[s.charAt(i) - 'a'];
        }
        return aux.words;
    }
    public boolean find(String s){
        Trie aux = this;
        for(int i = 0 ; i < s.length() ; ++i){
            if(aux.sons[s.charAt(i) - 'a'] == null){
                return false;
            }
            aux = aux.sons[s.charAt(i) - 'a'];
        }
        return aux.finalWord;
    }
}