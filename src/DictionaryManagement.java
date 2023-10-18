import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement {

    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Nhập số từ vựng :");
        num = Integer.parseInt(sc.next());
        for (int i = 0; i < num; i++) {
            System.out.print("Nhập từ tiếng anh: ");
            String engWord = sc.next();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.print("Nhập phat am: ");
            String engPhatam = sc.nextLine();
            System.out.print("Nhap tu tieng viet: ");
            String vieWord = sc.nextLine();
            vieWord += "\n";
            Dictionary.dictionaries.add(new Word(vieWord, engWord, engPhatam));
            Dictionary.add();
        }
    }
    public static void setStarWord(int index) {
        Word word_choose = Dictionary.getWord(index - 1);
        Dictionary.add_starword(word_choose);
    }
    public static void printMyStarWord() {
        ArrayList<Word> star = Dictionary.getStars();
        int numWordInDic = star.size();
        for (int i = 0; i < numWordInDic; i++) {
            String engWord = star.get(i).getTarget();
            String engPro = star.get(i).getPronounce();
            String vieWord = star.get(i).getExplain();
            System.out.printf("%d %s\t %s\n %s\n", i + 1, engWord, engPro, vieWord);
        }
    }
    public static void showAllWords() {
        Dictionary.showAllWords();
    }
    public static void removeWord(int ind) {
        int size = Dictionary.dictionaries.size();
        if(ind > size ) {
            System.out.println("The index is larger or smaller than size of Dictionary");
        }
        else {
            Dictionary.removeWord(ind - 1);
        }
    }
    public static void removestar(int ind) {
         int size = Dictionary.stars.size();
        if(ind > size ) {
            System.out.println("The index is larger or smaller than size of MyStar Words");
        }
        else {
     Dictionary.removeStar(ind - 1);
        }
    }
    public static void main(String[] args) {
        Dictionary tmp = new Dictionary();
        Scanner scan = new Scanner(System.in);
        String[] arr = { "Exit", "Add a new word to My Star Words", "Set the star word", "Show all Words in Dictionary",
                "Show all My Star Words", "Remove word from Dictionary", "Remove word from My Star Word", "Search",
                "Game", "Import From File", "Export to file" };
        List<String> list = Arrays.asList(arr);
        while (true) {
            System.out.println("Welcome to My Application!");
            for (int i = 0; i < 11; i++) {
                System.out.print("[" + i + "]");
                System.out.println(list.get(i));
            }
            System.out.println("Your action: ");
            int action = Integer.parseInt(scan.next());
            if (action == 1) {
                insertFromCommandline();
            } else if (action == 2) {
                System.out.print("Please give me the index of Word :");
                int index = Integer.parseInt(scan.next());
                setStarWord(index);
            } else if (action == 3) {
                showAllWords();
            } else if (action == 4) {
                printMyStarWord();
            } else if (action == 5) {
                System.out.print("Please give me the index of Word :");
                int index = Integer.parseInt(scan.next());
                removeWord(index);
            } else if (action == 6) {
                System.out.print("Please give me the index of Word :");
                int index = Integer.parseInt(scan.next());
                removestar(index);
            } else if (action == 7) {
                // Search the word
                System.out.print("Please give me the word which you need to search :");
                String sea = scan.next();
                String ans = Dictionary.searchWord(sea);
                System.out.println(ans);
            } else if (action == 8) {
                // Game

            } else if (action == 9) {
                // Import to file
                System.out.print("Please give me the path to the Dictionary (file .txt)");
                String path = scan.next();
                Dictionary.ImportFromOtherDic(path);
            } else if (action == 10) {
                // Export to file
                System.out.print("Please give me the path to the Dictionary (file .txt)");
                String path = scan.next();
                Dictionary.ExportToOtherFile(path);
            } else {
                break;
            }
        }
    }
}
