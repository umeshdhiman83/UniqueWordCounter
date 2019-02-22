import java.io.File;
import java.io.IOException;
import java.util.Map;
// import java.util.Scanner;

/**
 * Unique words calculator in a text file and lists top 10 occurences, assuming hyphen and apostrophe as part of word
 */
public class UniqueWordCounter {
    public static void main(String[] args) throws IOException {
        MapUtils mu = new MapUtils();

       // System.out.print("Enter a file name to count unique words: ");
       // Scanner input = new Scanner(System.in);
       // File file = new File(input.nextLine());
        File file = new File("tempest.txt");

        Map<String, Integer> wordsAndCountMap = mu.fileToMapConverter(file);
        Map<String, Integer> sortedMapWithTopElements = mu.sortMap(wordsAndCountMap);
        mu.printMap(sortedMapWithTopElements);
    }
}
