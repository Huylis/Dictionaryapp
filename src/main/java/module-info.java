module DictionaryApplication {
    requires javafx.controls;
    requires javafx.fxml;
//    requires freetts;
//    requires json.simple;

    opens DictionaryApplication.Controllers to javafx.fxml;

    exports DictionaryApplication;
}
