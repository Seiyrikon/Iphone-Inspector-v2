package utils;

public enum Constants {
    APP_TITLE("CellWeGo Iphone Inspector"),

    MINIMIZE_BUTTON("_"),
    MAXIMIZE_BUTTON("▢"),
    CLOSE_BUTTON("X"),

    SCAN("Scan"),
    SCAN_ICON("/resources/icons/scan-icon.png"),

    GENERATE("Generate"),
    GENERATE_ICON("/resources/icons/generate-icon.png"),

    PRINT("Print"),
    PRINT_ICON("/resources/icons/print-icon.png");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
