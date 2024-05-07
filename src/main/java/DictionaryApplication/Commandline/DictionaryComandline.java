package DictionaryApplication.Commandline;

import DictionaryApplication.Commandline.DictionaryManagement;

import java.util.Scanner;
import java.util.TreeMap;

public class DictionaryComandline {
    private DictionaryManagement dictionaryManagement ;
    Scanner scanner = new Scanner(System.in);

    public DictionaryManagement getDictionaryManagement() {
        return dictionaryManagement;
    }

    public DictionaryComandline(DictionaryManagement dictionaryManagement) {
        this.dictionaryManagement = dictionaryManagement;
    }
    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile("dictionary.txt");
        while (true) {
            // Hiển thị menu dòng lệnh
            System.out.println("Welcome to My Application!");
            System.out.println("[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display");
            System.out.println("[5] Lookup");
            System.out.println("[6] Search");
            System.out.println("[7] Game");
            System.out.println("[8] Import from file");
            System.out.println("[9] Export to file");
            System.out.print("Your action: ");

            // Đọc lựa chọn của người dùng
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Xử lý ngoại lệ nếu người dùng nhập không phải là một số
                System.out.println("Action not supported");
                continue; // Tiếp tục vòng lặp để yêu cầu lựa chọn mới
            }

            // Xử lý lựa chọn của người dùng
            switch (choice) {
                case 0:
                    dictionaryManagement.exportToFile(dictionaryManagement.getDictionary(),"src/main/resources/dictionary.txt");
                    System.out.println("Exiting...");
                    return; // Thoát khỏi vòng lặp và kết thúc phương thức
                case 1:
                    dictionaryManagement.addWord();
                    System.out.println("Nhap enter de tiep tuc!");
                    scanner.nextLine();
                    break;
                case 2:
                    dictionaryManagement.deleteWord();
                    System.out.println("Nhap enter de tiep tuc!");
                    scanner.nextLine();
                    break;
                case 3:
                    dictionaryManagement.editWord();
                    System.out.println("Nhap enter de tiep tuc!");
                    scanner.nextLine();
                    break;
                case 4:
                    showAllWords();
                    System.out.println("Nhap enter de tiep tuc!");
                    scanner.nextLine();
                    break;
                case 5:
                    dictionaryManagement.dictionaryLookup();
                    System.out.println("Nhap enter de tiep tuc!");
                    scanner.nextLine();
                    break;
                case 6:
                    dictionarySearcher();
                    System.out.println("Nhap enter de tiep tuc!");
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.println("Chua co game");
                    System.out.println("Nhap enter de tiep tuc!");
                    scanner.nextLine();
                    break;
                case 8:
                    dictionaryManagement.insertFromFile("dictionary.txt");
                    System.out.println("Nhap enter de tiep tuc!");
                    scanner.nextLine();
                    break;
                case 9:
                    dictionaryManagement.exportToFile(dictionaryManagement.getDictionary(),"src/main/resources/dictionary.txt");
                    System.out.println("Nhap enter de tiep tuc!");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Action not supported");
            }
        }
    }
    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        // Nhập từ điển từ bàn phím
        // Hiển thị danh sách từ vựng
        dictionaryManagement.exportToFile(dictionaryManagement.getDictionary(),"src/main/resources/dictionary.txt");
        dictionaryManagement.insertFromFile("dictionary.txt");
        showAllWords();
    }
    public void showAllWords() {
        TreeMap<String, Word> words = dictionaryManagement.getDictionary().getWords();
        System.out.println("No   |  English   |  Vietnamese");
        int i = 1; // Khởi tạo biến đếm
        for (Word word : words.values()) {
            System.out.printf("%-3d  |  %-8s   |  %s%n", i++, word.getWord_target(), word.getWord_explain());
        }
    }
    public void dictionarySearcher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Go tu khoa can tim kiem neu muon thoat nhan 'esc':");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("esc")) {
                break;
            } else if (input.isEmpty()) {
                System.out.println("Please enter a character or 'exit' to quit.");
                continue;
            }

            char c = input.toLowerCase().charAt(0);

            System.out.println("Matching words:");
            for (Word word : dictionaryManagement.getDictionary().getWords().values()) {
                if (word.getWord_target().toLowerCase().contains(String.valueOf(c))) {
                    System.out.println(word.getWord_target() + ": " + word.getWord_explain());
                }
            }
        }
    }
}
