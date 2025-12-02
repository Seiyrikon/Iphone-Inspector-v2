package services.device;

import java.util.List;

import model.IphoneModel;
import utils.CommandExecutor;
import utils.CommandResult;
import utils.Constants;

public class DeviceService {

    CommandExecutor commanderService;
    List<String> commands;

    public DeviceService(CommandExecutor commanderService) {
        this.commanderService = commanderService;
    }

    public CommandResult detect() {
        CommandResult result = CommandExecutor.runTool(Constants.IDEVICE_ID.get().toString(),
                Constants.DEVICE_LIST.get().toString());
        return result;
    }

    public IphoneModel extractInfo() {
        IphoneModel iphone = new IphoneModel();
        CommandResult result = CommandExecutor.runTool(Constants.IDEVICE_INFO.get().toString());

        String[] parts = result.output.split(",");

        for(String part : parts) {
            if(part.contains("InternationalMobileEquipmentIdentity:")) {
                String[] labels = part.split(" ");
                // mappedInformations.add("IMEI/MEID: " + parts[1]);
                iphone.setImei("IMEI/MEID: " + labels[1]);
                continue;
            }
            
            if(part.contains("InternationalMobileEquipmentIdentity2:")) {
                String[] labels = part.split(" ");
                // mappedInformations.add("IMEI2: " + labels[1]);
                iphone.setImei2("IMEI2: " + labels[1]);
                continue;
            }
            
            if(part.contains("SerialNumber:")) {
                String[] labels = part.split(" ");
                // mappedInformations.add("(S) Serial No: " + labels[1]);

                if(labels[0].matches("(?i)^SerialNumber:$"))
                iphone.setSerialNo("(S) Serial No: " + labels[1]);
                continue;
            }
            
            if(part.contains("ModelNumber:")) {
                String[] labels = part.split(" ");
                // modelNumberRegion += labels[1];
                iphone.setModel(labels[1]);
                continue;
            }

            if(part.contains("RegionInfo:")) {
                String[] labels = part.split(" ");
                // modelNumberRegion += labels[1];
                iphone.setRegion(labels[1]);
                continue;
            }
            
            if(part.contains("ProductName:")) {
                String[] labels = part.split(" ");
                // mappedInformations.add("Product Name: " + labels[1]);
                iphone.setProductName("Product Name: " + labels[1]);
                continue;
            }
            
            if(part.contains("ProductType:")) {
                String[] labels = part.split(" ");
                // mappedInformations.add("Product Type: " + labels[1]);
                iphone.setProductType("Product Type: " + labels[1]);
                continue;
            }
            
            if(part.contains("ProductVersion:")) {
                String[] labels = part.split(" ");
                // mappedInformations.add("Product Version: " + labels[1]);
                iphone.setProductVersion("Product Version: " + labels[1]);
                continue;
            }
        }

        return iphone;
    }
}
