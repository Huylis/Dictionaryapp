package DictionaryApplication.Commandline;

import DictionaryApplication.Commandline.DictionaryManagement;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Dictionary
        Dictionary dictionary = new Dictionary();
        // Tạo đối tượng DictionaryManagement
        DictionaryManagement dictionaryManagement = new DictionaryManagement(dictionary);
        // Tạo đối tượng DictionaryCommandLine
        DictionaryComandline dictionaryCommandLine = new DictionaryComandline(dictionaryManagement);
        // Thực hiện chức năng cơ bản của từ điển
        // dictionaryCommandLine.dictionaryBasic();
        dictionaryCommandLine.dictionaryAdvanced();
    }
}
