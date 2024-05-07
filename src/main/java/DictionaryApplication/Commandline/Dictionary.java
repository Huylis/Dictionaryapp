package DictionaryApplication.Commandline;

import java.util.TreeMap;

public class Dictionary {
    private TreeMap<String,Word> words;
    public Dictionary() {
        words = new TreeMap<>();
    }
    public void addWord(String wordtarget, String wordexplain) {
        Word newWord =new Word(wordtarget,wordexplain);
        words.put(wordtarget.toLowerCase(), newWord);
    }
    public boolean removeWord(String wordTarget) {
        return words.remove(wordTarget.toLowerCase()) != null;
    }
    public Word findword(String wordfind) {
        return words.get(wordfind.toLowerCase());
    }

    public TreeMap<String, Word> getWords() {
        return words;
    }

    public void setWords(TreeMap<String, Word> words) {
        this.words = words;
    }
}
