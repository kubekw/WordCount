package model;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class WordCount {

    Map<String, Integer> wordCounter = new HashMap<>();

    public Map<String, Integer> phrase(String phraseWithWordsToCount) {
        String[] words = splitPhraseForWordsAndLowerCaseThem(phraseWithWordsToCount);
        AddWordsToMapAndCount(words);

        return wordCounter;
    }

    private void AddWordsToMapAndCount(String[] words) {
        for(String word:words){
            if(!word.isBlank()) {
                ifMapContainWordIncrementValue(word);
                ifMapDontContainWordAddWordToMap(word);
            }
        }
    }

    private void ifMapContainWordIncrementValue(String word) {
        if(wordCounter.containsKey(word)){
            int occurrencess = wordCounter.get(word);
            occurrencess++;
            wordCounter.put(word,occurrencess);
        }
    }

    private void ifMapDontContainWordAddWordToMap(String word) {
        if (!wordCounter.containsKey(word)){
            wordCounter.put(word,1);
        }
    }

    private String[] splitPhraseForWordsAndLowerCaseThem(String phrase) {
            String[] words = phrase
                    .replaceAll("([^A-Za-z0-9']|\\B'|'\\B)"," ")
                    .toLowerCase(Locale.ROOT).split(" |\n|\t|,|, ");
        return words;
    }
}
