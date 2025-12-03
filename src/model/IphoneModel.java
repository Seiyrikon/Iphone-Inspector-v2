package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IphoneModel {
    private String uid;
    private String imei = "Sample imei";
    private String imei2 = "Sample imei2";
    private String eid;
    private String serialNo = "Sample serialNo";
    private String storageType;
    private String version = "Sample version";
    private String icc;
    private String fcc;
    private String model = "model";
    private String region = "region";
    private String productName = "Sample productName";
    private String productType = "Sample productType";
    private String productColor = "Sample productColor";
    private String productVersion = "Sample productVersion";
}
