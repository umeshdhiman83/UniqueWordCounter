import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class to provide utility methods for maps operations
 */
class MapUtils{

    /**
     * Function to create a Map from File words. It will read all the words from the file.
     * Words will act as key and count of words will be value
     * It will ignore cases so "and" and "And" will count as one word
     *
     * @param file-name
     * @return Map of words as keys and occurences count as value
     */
    public Map<String, Integer> fileToMapConverter(File file) throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";
        Map<String, Integer> wordsAndCounts = new HashMap<>();
        try{
            while((line = reader.readLine()) != null){
                String[] words = line.split("[ \n\t\r.,;:!?]");
                for (int i = 0;i<words.length;i++){
                    String key = words[i].toLowerCase();
                    if(key.length() >0){
                        if(wordsAndCounts.get(key) == null){
                            wordsAndCounts.put(key,1);
                        }else{
                            int value = wordsAndCounts.get(key).intValue();
                            wordsAndCounts.put(key,++value);
                        }
                    }
                }
            }
        }finally {
            reader.close();
        }
        return wordsAndCounts;
    }

    /**
     * Function to soft a map on the basis of value in reverse order
     * @param map name to be sorted
     * @return reverse sorted map on the basis of value
     */
    public Map<String, Integer> sortMap(Map<String, Integer> map){
        Map<String, Integer> sortedTopEntries = map.entrySet().stream()
                .sorted(Collections.reverseOrder
                (Map.Entry.comparingByValue()))
                .limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(val1, val2)->val1, LinkedHashMap:: new));

        return sortedTopEntries;
    }

    /**
     * Function to print a map
     * @param mapToPrint map to be printed
    */
    public void printMap(Map<String, Integer> mapToPrint){
        for (Map.Entry<String, Integer> entry : mapToPrint.entrySet())
        {
            System.out.println(entry.getKey() + "(" + entry.getValue() + ")");
        }
    }

}