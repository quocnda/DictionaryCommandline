import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    public static void insertFromCommandline(){
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Nhập số từ vựng :");
        num = sc.nextInt();
        for(int i=0; i<num; i++) {
            System.out.print("Nhập từ tiếng anh: ");
            String vieWord = sc.next();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.print("Nhập phat am: ");
            String engPhatam = sc.nextLine();
            System.out.print("Nhap tu tieng viet: ");
            String engWord = sc.nextLine();
            engWord = engPhatam + "\n" + engWord;
            Dictionary.dictionaries.add(new Word(engWord, vieWord));
            Dictionary.add();
        }
    }
    public static void setStarWord(int index) {
        Word word_choose = Dictionary.getWord(index);
        Dictionary.stars.add(word_choose);
    }
    public static void printMyStarWord() {
        ArrayList<Word> star = Dictionary.getStars();
        int numWordInDic = star.size();
        for(int i = 0;i<numWordInDic ;i++) {
            String engWord = star.get(i).getTarget();
            String vieWord = star.get(i).getExplain();
            System.out.printf("%d %s\t\t %s\n", i+1,engWord,vieWord  );
        }
    }
    public static void showAllWords() {
        Dictionary.showAllWords();
    }
    public static void main(String[] args) {
       Dictionary tmp = new Dictionary();
       Scanner scan = new Scanner(System.in);

        while(true) {
            int action = Integer.parseInt(scan.next());
            if(action == 1) {
                insertFromCommandline();
            }
            else if (action == 2) {
                System.out.print("Please give me the index of Word :");
                int index = Integer.parseInt(scan.next());
                setStarWord(index);
            }
            else if (action == 3) {
                showAllWords();
            }
            else if (action == 4) {
                printMyStarWord();
            }
        }     
    }
}
