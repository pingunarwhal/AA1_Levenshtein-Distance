import java.util.*;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = word;
    }


    public List<String> findWordsWithinDistanceIterative(String initialWord, int distance) {
        List<String> wordsWithinDistance = new ArrayList<>();
        searchRecursiveIterative(root, initialWord, distance, wordsWithinDistance);
        return wordsWithinDistance;
    }

    private void searchRecursiveIterative(TrieNode node, String initialWord, int distance, List<String> results) {
        int currentDistance = LevenshteinDistance.levenshteinDistanceIterative(node.word, initialWord);

        if (currentDistance <= distance && node.word.length() != 0) {
            results.add(node.word);
        }
        if (currentDistance < distance || node.word.length() == 0) {
            for (TrieNode child : node.children.values()) {
                searchRecursiveIterative(child, initialWord, distance, results);
            }
        }

    }

    public List<String> findWordsWithinDistanceRec(String initialWord, int distance) {
        List<String> wordsWithinDistance = new ArrayList<>();
        searchRecursiveRec(root, initialWord, distance, wordsWithinDistance);
        return wordsWithinDistance;
    }

    private void searchRecursiveRec(TrieNode node, String initialWord, int distance, List<String> results) {
        int[][] distancearray = new int[initialWord.length() + 1][node.word.length() + 1];
        for (int i = 0; i < distancearray.length; i++) {
            Arrays.fill(distancearray[i], -1);
        }

        int currentDistance = LevenshteinDistance.levenshteinDistanceRecursive(initialWord, node.word, distancearray);

        if (currentDistance <= distance && node.word.length() != 0) {
            results.add(node.word);
        }
        if (currentDistance < distance || node.word.length() == 0) {
            for (TrieNode child : node.children.values()) {
                searchRecursiveRec(child, initialWord, distance, results);
            }
        }
    }

    private static class TrieNode {
        private String word;
        private final Map<Character, TrieNode> children;

        public TrieNode() {
            word = "";
            children = new HashMap<>();
        }
    }
}
