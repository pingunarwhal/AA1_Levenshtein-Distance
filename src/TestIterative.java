import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TestIterative {
    public static void main(String[] args) throws IOException {
        File directory = new File("in/");
        Path path = Paths.get("outx");

        if (Files.exists(path)) {
            File resultFile = new File(String.valueOf(path));
            for (File file : Objects.requireNonNull(resultFile.listFiles())) {
                file.delete();
            }
            resultFile.delete();
        }
        Files.createDirectories(path);

        System.out.println("Start iterative:");

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            String filepath = "outx/" + file.getName().replace(".in", ".out");
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file, out);
            }
        }
    }

    private static void action(File input, File output) throws IOException {
        Trie trie = new Trie();
        Scanner myReader = new Scanner(input);

        int n = myReader.nextInt();
        int k = myReader.nextInt();
        String initWord = null;
        if (myReader.hasNext()) {
            initWord = myReader.nextLine();
            initWord = myReader.nextLine();
        }

        while (myReader.hasNext()) {
            trie.insert(myReader.nextLine());
        }

        Instant start = Instant.now();
        List<String> result = trie.findWordsWithinDistanceIterative(initWord, k);
        Instant finish = Instant.now();
        Duration duration = Duration.between(start, finish);
        System.out.println("time elapsed for " + input.getName() + ": " + duration.toSeconds() + " s " + duration.toMillis() % 1000 + " ms " + duration.toNanos() % 1000000 + " ns");

        FileWriter myWriter = new FileWriter(output.getAbsoluteFile());
        myWriter.write(result.size() + "\n");
        for (String word : result) {
            myWriter.write(word + "\n");
        }

        myWriter.close();
    }
}
