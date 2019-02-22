import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class MapUtils{
    public Map<String, Integer> fileToMapConverter(File file) throws FileNotFoundException, IOException{
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        String line = "";
        Map<String, Integer> wordsAndCounts = new HashMap<>();
        try{
            while((line = reader.readLine()) != null){
                String[] words = line.split("[ \n\t\r.,;:!?]");
                for(int i = 0;i<words.length;i++){
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

    public Map<String, Integer> sortMap(Map<String, Integer> map){
        Map<String, Integer> sortedTopEntries = map.entrySet().stream()
                .sorted(Collections.reverseOrder
                        (Map.Entry.comparingByValue()))
                .limit(10).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (val1, val2)->val1,
                                LinkedHashMap:: new));

        return sortedTopEntries;
    }

    public void printMap(Map<String, Integer> mapToPrint){
        for (Map.Entry<String, Integer> entry : mapToPrint.entrySet())
        {
            System.out.println(entry.getKey() + "(" + entry.getValue() + ")");
        }
    }

}