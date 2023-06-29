#### Constantinescu Delia - Georgiana
#### Grupa 323CA
### Tema 1 Analiza Algoritmilor

Levenshtein distance implementation:
* `static int levenshteinDistanceIterative(String a, String b)`: Computes the Levenshtein distance 
between two strings using an iterative algorithm.
* `static int levenshteinDistanceRecursive(String a, String b, int[][] distanceArray)`: Computes the 
Levenshtein distance between two strings using a recursive algorithm and memoization.

Trie implementation:
* `void insert(String word)`: Inserts a word into the trie.
* `List<String> findWordsWithinDistanceIterative(String initialWord, int distance)`: Returns a list 
of words in the trie that are within a certain distance of a given initial word, using an iterative 
implementation of the Levenshtein distance algorithm.
* `List<String> findWordsWithinDistanceRec(String initialWord, int distance)`: Returns a list of 
words in the trie that are within a certain distance of a given initial word, using a recursive 
implementation of the Levenshtein distance algorithm.

The TestRecursive and TestIterative classes contain test cases that compare the performance of the 
iterative and recursive implementations of the Levenshtein distance algorithm.

Bibliography:
* http://stevehanov.ca/blog/?id=114
* https://www.geeksforgeeks.org/edit-distance-dp-5/