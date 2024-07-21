import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharacterByFrequency_leetcode451 {
        public static void main(String[] args) {
            // Sample string
            String str = "AabbbaCcbert";

            StringBuilder ans = new StringBuilder();

            // Use a HashMap to count frequencies of each character
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char c : str.toCharArray()) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }

            System.out.println(freqMap);

            // Create a list of characters from the string
            List<Character> characters = new ArrayList<>(freqMap.keySet());


            System.out.println(characters.toString());

            // Sort characters based on frequencies in descending order
            characters.sort((ob1, ob2) -> {
                       if(freqMap.get(ob2) > freqMap.get(ob1))
                           return 1;
                       else
                           return -1;
            });

            // Print characters sorted by frequency
            for (char c : characters) {
               for(int i=0; i<freqMap.get(c);i++){
                   ans.append(c);
               }
            }
            System.out.println(ans.toString());
        }
    }

