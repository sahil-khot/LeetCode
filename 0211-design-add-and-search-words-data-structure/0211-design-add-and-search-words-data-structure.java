class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
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

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode curr, String word, int index) {

        // Complete word reached
        if(index == word.length()) {
            return curr.isEnd;
        }

        char ch = word.charAt(index);

        // Normal character
        if(ch != '.') {

            int idx = ch - 'a';

            if(curr.children[idx] == null) {
                return false;
            }

            return dfs(curr.children[idx], word, index + 1);
        }

        // '.' → try every possible character
        for(int i = 0; i < 26; i++) {

            if(curr.children[i] != null) {

                if(dfs(curr.children[i], word, index + 1)) {
                    return true;
                }
            }
        }

        return false;
    }
}