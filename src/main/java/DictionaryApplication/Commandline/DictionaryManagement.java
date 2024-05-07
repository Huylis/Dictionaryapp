package DictionaryApplication.Commandline;

import DictionaryApplication.Commandline.Word;

import java.io.*;
import java.util.*;

public class DictionaryManagement {
    public int n;
    private Dictionary dictionary ;
    Scanner sc = new Scanner(System.in);

    public Dictionary getDictionary() {
        return dictionary;
    }

    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void insertFromCommandline() {
        System.out.print("Nhap vao so tu muon them: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Word word = new Word();
            System.out.println("Nhap tu thu : " + (i + 1));
            word.setWord_target(sc.next());
            System.out.println("Nhap nghia cua tu: ");
            word.setWord_explain(sc.next());
            dictionary.addWord(word.getWord_target(), word.getWord_explain());

        }

    }

    public void insertFromFile(String fileName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream != null) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split("\t");
                        if (parts.length >= 2) {
                            String wordTarget = parts[0].trim();
                            String wordExplain = parts[1].trim();
                            dictionary.addWord(wordTarget, wordExplain);
                        }
                    }
                }
            } else {
                System.err.println("File not found: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    public void dictionaryLookup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word to lookup:");
        String wordToLookup = scanner.nextLine().trim();

        Word foundWord = dictionary.findword(wordToLookup.toLowerCase());
        if (foundWord != null) {
            System.out.println("Meaning of '" + foundWord.getWord_target() + "': " + foundWord.getWord_explain());
        } else {
            System.out.println("Word '" + wordToLookup + "' not found in the dictionary.");
        }
    }
    // Thêm từ vựng mới
    public void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new word:");
        String wordTarget = scanner.nextLine().trim();
        System.out.println("Enter word explanation:");
        String wordExplain = scanner.nextLine().trim();

        dictionary.addWord(wordTarget, wordExplain);
        System.out.println("Word added successfully.");
    }

    // Sửa từ vựng
    public void editWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word to edit:");
        String wordTarget = scanner.nextLine().trim();

        Word word = dictionary.findword(wordTarget);
        if (word != null) {
            System.out.println("Enter new target:");
            String newTarget = scanner.nextLine().trim();
            word.setWord_target(newTarget);
            System.out.println("Enter new explanation:");
            String newExplanation = scanner.nextLine().trim();
            word.setWord_explain(newExplanation);
            System.out.println("Word updated successfully.");
        } else {
            System.out.println("Word not found.");
        }
    }
    public static void removeWordFromFile(String fileName, String wordToRemove) {
        // Đọc nội dung từ file vào một danh sách
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Tìm và xóa từ cần xóa khỏi danh sách
        lines.removeIf(line -> line.startsWith(wordToRemove));

        // Ghi lại nội dung còn lại vào file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Xóa từ vựng
    public void deleteWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word to delete:");
        String wordTarget = scanner.nextLine().trim();

        boolean success = dictionary.removeWord(wordTarget);
        if (success) {
            System.out.println("Word deleted successfully.");
        } else {
            System.out.println("Word not found.");
        }
    }
    // Xuất dữ liệu từ điển ra tệp
    public void exportToFile(Dictionary dictionary, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            // Ghi dữ liệu vào tệp
            for (Word word : dictionary.getWords().values()) {
                bufferedWriter.write(word.toString());
                bufferedWriter.newLine();
            }
            System.out.println("Data overwritten to file successfully.");
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e);
        }
    }


}


