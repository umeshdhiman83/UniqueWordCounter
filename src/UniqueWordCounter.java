import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

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
