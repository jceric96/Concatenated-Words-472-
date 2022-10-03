import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcateWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<>();

        List<String> result = new ArrayList<>();
        if (words.length <= 1) {
            return result;
        }
        for (String word : words) {
            dict.add(word);
        }

        for (String word : words) {
            if (helper(dict, word, 0)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean helper(Set<String> dict, String word, int start) {
        if (word.length() == 0) {
            return false;
        }
        if (start == word.length()) {
            return true;
        }
        boolean result = false;
        for (int i = word.length(); i >= start + 1; i--) {
            String sub = word.substring(start, i);
            if (dict.contains(sub) && !sub.equals(word)) {
                result = result || helper(dict, word, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ConcateWords cw = new ConcateWords();
        String[] words = new String[] { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat",
                "ratcatdogcat" };
        System.out.println(cw.findAllConcatenatedWordsInADict(words));
    }
}
