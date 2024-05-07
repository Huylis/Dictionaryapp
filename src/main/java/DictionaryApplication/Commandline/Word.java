package DictionaryApplication.Commandline;

public class Word {
    private String word_target;
    private String word_explain;
    public Word(){

    }
    public Word(String wordTarget, String wordExplain) {
        this.word_target = wordTarget;
        this.word_explain = wordExplain;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    @Override
    public String toString() {
        return word_target + "\t" + word_explain;
    }
}
