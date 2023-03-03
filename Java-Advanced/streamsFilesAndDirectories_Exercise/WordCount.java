package streamsFilesAndDirectories_Exercise;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String pathWords = "C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\words.txt";
        //. 1 finding the words we will be looking for
        List<String> allLinesWithWords = Files.readAllLines(Path.of(pathWords));
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String line : allLinesWithWords) {
            line = line.replaceAll("[\\. \\, \\? \\! \\:]", "");
            String[] wordsOnCurrentRow = line.split("\\s+");
            Arrays.stream(wordsOnCurrentRow).forEach(word -> {
                wordsCount.put(word, 0);
            });
        }
        //2. check how many times these words are encountered in the text file
        String pathText = "C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\text.txt";
        List<String> allLinesWithinText = Files.readAllLines(Path.of(pathText));
        for (String line : allLinesWithinText) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (wordsCount.containsKey(word)) {
                    wordsCount.put(word, wordsCount.get(word) + 1);
                }
            }
        }
        // sort the map keys depending on their occurrences count. (sort by value)
        PrintWriter writer = new PrintWriter("result.text");
        wordsCount.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))//sorting them
                .forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue())); //printing value
        writer.close();
    }
}