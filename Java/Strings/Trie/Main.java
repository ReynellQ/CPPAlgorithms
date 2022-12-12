public class Main {
    public static void main(String[] args) {
        Trie t = new Trie();
        String[] words = {"hola", "adios", "prueba", "prueb", "externo", "apoptosis", "creatividad"};
        for(String word : words){
            t.addWord(word);
        }
        for(String word : words){
            System.out.println(t.find(word));
        }
        t.remove(words[0]);
        for(String word : words){
            System.out.println(t.find(word));
        }

    }
    static class Trie{
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
        public void remove(String s){
            Trie aux = this;
            aux.words--;
            for(int i = 0 ; i < s.length() ; ++i){
                aux.sons[s.charAt(i) - 'a'].words--;
                if(aux.sons[s.charAt(i) - 'a'].words == 0){
                    aux.sons[s.charAt(i) - 'a'] = null;
                    break;
                }
                aux = aux.sons[s.charAt(i) - 'a'];
                aux.finalWord = false;
            }
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
}
