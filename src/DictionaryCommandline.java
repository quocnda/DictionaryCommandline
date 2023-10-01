public class DictionaryCommandline {
    public static void showAllWords() {
        System.out.println("No \t |English \t |Vietnamese");
        int numWordInDic = Dictionary.dictionaries.size();
        for(int i = 0; i < numWordInDic; i++) {
            String engWord = Dictionary.dictionaries.get(i).getTarget();
            String vieWord = Dictionary.dictionaries.get(i).getExplain();

            System.out.printf("%d\t |%s\t\t |%s\n", i+1,vieWord ,engWord );
        }
    }

    public static void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        DictionaryCommandline.showAllWords();
    }

    public static void main(String[] args){
        dictionaryBasic();
    }
}
