public class Word {
    private String word_target;
    private String word_explain;
    private String word_pronounce;
    public Word(String word_explain, String word_target,String word_pro) {
        this.word_explain = word_explain;
        this.word_target = word_target;
        this.word_pronounce = word_pro;
    }

    public Word() {
        word_explain = "";
        word_target = "";
        word_pronounce = "";
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
    public String getPronounce() {
        return this.word_pronounce;
    }
    public void setPronounce(String word_pro) {
        this.word_pronounce = word_pro;
    }
    public void addLineExplain(String line_explain) {
        word_explain += line_explain + "\n";
    }
}
