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
    PRINT_ICON("/resources/icons/print-icon.png"),

    IDEVICE_ID("idevice_id.exe"),
    DEVICE_LIST("-l"),

    IDEVICE_INFO("ideviceinfo.exe"),

    IMEI("IMEI/MEID: "),
    IMEI2("IMEI2: "),
    EID("EID: "),
    SERIAL_NUMBER("(S) Serial No: "),
    STORAGE_TYPE("Storage: "),
    COLOR_TYPE("Color: "),
    MODEL_NUMBER("Model Number: "),
    PRODUCT_NAME("Product Name: "),
    PRODUCT_TYPE("Product Type: "),
    PRODUCT_VERSION("Product Version: ");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
