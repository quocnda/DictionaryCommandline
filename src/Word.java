public class Word {
    private String word_target;
    private String word_explain;

    public Word(String word_explain, String word_target) {
        this.word_explain = word_explain;
        this.word_target = word_target;
    }

    public Word() {
        word_explain = "";
        word_target = "";

    }

    public String getTarget() {
        return word_target;
    }

    public void setTarget(String word_target) {
        this.word_target = word_target;
    }

    public String getExplain() {
        return word_explain;
    }

    public void setExplain(String word_explain) {
        this.word_explain = word_explain;
    }

    public void addLineExplain(String line_explain) {
        word_explain += line_explain + "\n";
    }
}
