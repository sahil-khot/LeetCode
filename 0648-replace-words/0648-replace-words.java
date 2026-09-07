class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Solution {
    TrieNode root = new TrieNode();
    boolean isEnd = false;

    public String replaceWords(List<String> dictionary, String sentence) {
        for(int i = 0; i < dictionary.size(); i++) {
            String word = dictionary.get(i);
            addWord(word);
        }

        String[] words = sentence.trim().split(" ");

        for(int i = 0; i < words.length; i++) {
            String newWord = start(words[i]);
            words[i] = newWord;
        }

        return String.join(" ", words);
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public String start(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (curr.children[index] == null) {
                return word;
            }

            sb.append(ch);
            curr = curr.children[index]; 

            if(curr.isEnd){
                return sb.toString();
            }
        }
        return word;
    }
}