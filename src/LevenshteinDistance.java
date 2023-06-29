public class LevenshteinDistance {
    public static int levenshteinDistanceIterative(String s1, String s2) {
        int[][] distance = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            distance[0][j] = j;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1), distance[i - 1][j - 1] + cost);
            }
        }
        return distance[s1.length()][s2.length()];
    }

    public static int levenshteinDistanceRecursive(String s1, String s2, int[][] distance) {
        int m = s1.length();
        int n = s2.length();

        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (distance[m][n] != -1) {
            return distance[m][n];
        }

        int cost = (s1.charAt(m - 1) == s2.charAt(n - 1)) ? 0 : 1;
        int delete = levenshteinDistanceRecursive(s1.substring(0, m - 1), s2, distance);
        int insert = levenshteinDistanceRecursive(s1, s2.substring(0, n - 1), distance);
        int swap = levenshteinDistanceRecursive(s1.substring(0, m - 1), s2.substring(0, n - 1), distance);

        distance[m][n] = cost + Math.min(Math.min(delete, insert), swap);
        return distance[m][n];
    }

}
