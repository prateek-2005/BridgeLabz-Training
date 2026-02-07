package collectors;
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        String paragraph = "Java is powerful and Java is popular";

        Map<String, Long> wordCount =
            Arrays.stream(paragraph.toLowerCase().split("\\s+"))
                  .collect(Collectors.toMap(
                      word -> word,        
                      word -> 1L,          
                      Long::sum            
                  ));

        System.out.println(wordCount);
    }
}
