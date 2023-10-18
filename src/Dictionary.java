import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class Dictionary {
    public static ArrayList<Word> dictionaries = new ArrayList<>();
    public static ArrayList<Word> stars = new ArrayList<>();
    public static ArrayList<Word> wordadd = new ArrayList<>();
    private static final String fileDict = "src/resources/data/Dicdemo.txt";
    private static final String fileStars = "src/resources/data/MyWords.txt";

    public Dictionary() {
        insertFromFile(dictionaries, fileDict);
        insertFromFile(stars, fileStars);
    }

    public static void insertFromFile(ArrayList<Word> words, String path) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            boolean b = true;
            String line;
            String tg;
            Word w = new Word();
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                } else {
                    if (line.contains("@")) {
                        if (!b) {
                            if (!w.getTarget().equals("")) {
                                words.add(w);
                            }
                        } else {
                            b = false;
                        }
                        w = new Word();
                        tg = line;
                        tg = tg.replace("@", "");
                        w.setTarget(tg);
                    } else if (line.contains("/")) {
                        w.setPronounce(line);
                    } else {
                        w.addLineExplain(line);
                    }
                }
            }
            if (!w.getTarget().equals("")) {
                words.add(w);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add() {
        exportToFile(dictionaries, fileDict);
    }

    public static void add_starword(Word starw) {
        stars.add(starw);
        exportToFile(stars, fileStars);
    }

    public static void showAllWords() {
        int numWordInDic = dictionaries.size();
        for (int i = 0; i < numWordInDic; i++) {
            String engWord = dictionaries.get(i).getTarget();
            String engPro = dictionaries.get(i).getPronounce();
            String vieWord = dictionaries.get(i).getExplain();
            System.out.printf("%d %s\t %s\n %s", i + 1, engWord, engPro, vieWord);
        }
    }

    public static void exportToFile(ArrayList<Word> words, String path) {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Word w : words) {
                System.out.println(w.getTarget() + " " + w.getTarget().length());
                bw.write("@" + w.getTarget() + "\n" + w.getPronounce() + "\n" + w.getExplain());
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getDictSize() {
        return dictionaries.size();
    }

    public int getStarsSize() {
        return stars.size();
    }

    public static Word getWord(int index) {
        return dictionaries.get(index);
    }

    public Word getStar(int index) {
        return stars.get(index);
    }

    public static ArrayList<Word> getStars() {
        return stars;
    }
    public static void ImportFromOtherDic(String path) {
        dictionaries.clear();
        insertFromFile(dictionaries, path);
    }
    public static void ExportToOtherFile(String path) {
        exportToFile(dictionaries, path);
    }
    public void sortAndInsert(boolean isDict, Word new_word) {
        new_word.addLineExplain("\n");
        ArrayList<Word> words;
        String file;
        if (isDict) {
            words = dictionaries;
            file = fileDict;
        } else {
            words = stars;
            file = fileStars;
        }
        boolean add = false;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getTarget().compareTo(new_word.getTarget()) > 0) {
                words.add(i, new_word);
                add = true;
                break;
            }
        }
        if (!add) {
            words.add(new_word);
        }
        exportToFile(words, file);
    }

    public static void removeWord(int index) {
        dictionaries.remove(index);
        exportToFile(dictionaries, fileDict);
    }

    public static void removeStar(int index) {
        stars.remove(index);
        exportToFile(stars, fileStars);
    }

    public static String searchWord(String word) {
        int numWordInDic = dictionaries.size();
        String ans = "";
        for (int i = 0; i < numWordInDic; i++) {
            String engWord = dictionaries.get(i).getTarget();
            if (engWord.equals(word)) {
                String vieWord = dictionaries.get(i).getExplain();
                ans = vieWord;
                return ans;
            }
        }
        ans = "Don't exit this word in Dictionary";
        return ans;
    }
}
