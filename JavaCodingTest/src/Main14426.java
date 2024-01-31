import java.util.*;
import java.io.*;

public class Main14426 {
    
    public static class TrieNode{

        public Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean endOfWord;
    }
    
    public static class Trie{

        public TrieNode rootNode;
        public Trie(){
            rootNode = new TrieNode();
        }
    
        public void insert(String str){

            TrieNode node = this.rootNode;

            for(int i =0; i< str.length();i++){
                node = node.childNodes.computeIfAbsent(str.charAt(i), key -> new TrieNode());

            }
            node.endOfWord = true;

        }

        public boolean search(String str){
            TrieNode node = this.rootNode;

            for(int i =0; i< str.length(); i++){
                node = node.childNodes.getOrDefault(str.charAt(i), null);
                if(node == null){
                    return false;
                }
            }
            return true;
        }

    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();
        for(int i=0;i < N; i++){
            String t = br.readLine();
            trie.insert(t);
        }
        int result = 0;
        for(int i =0; i< M ;i++){
          
            if(trie.search(br.readLine())){
                result +=1;
            }
        }

        System.out.println(result);



    }
}
