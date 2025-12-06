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

        String[] parts = result.output.split(Constants.INFO_SEPARATOR.get().toString());

        for(String part : parts) {
            if(part.contains("InternationalMobileEquipmentIdentity:")) {
                String[] labels = part.split(" ");
                iphone.setImei(labels[1]);
                continue;
            }
            
            if(part.contains("InternationalMobileEquipmentIdentity2:")) {
                String[] labels = part.split(" ");
                iphone.setImei2(labels[1]);
                continue;
            }
            
            if(part.contains("SerialNumber:")) {
                String[] labels = part.split(" ");

                if(labels[0].matches("(?i)^SerialNumber:$"))
                iphone.setSerialNo(labels[1]);
                continue;
            }
            
            if(part.contains("ModelNumber:")) {
                String[] labels = part.split(" ");
                iphone.setModel(labels[1]);
                continue;
            }

            if(part.contains("RegionInfo:")) {
                String[] labels = part.split(" ");
                iphone.setRegion(labels[1]);
                continue;
            }
            
            if(part.contains("ProductName:")) {
                String[] labels = part.split(" ");
                iphone.setProductName(labels[1]);
                continue;
            }
            
            if(part.contains("ProductType:")) {
                String[] labels = part.split(" ");
                iphone.setProductType(labels[1]);
                continue;
            }
            
            if(part.contains("ProductVersion:")) {
                String[] labels = part.split(" ");
                iphone.setProductVersion(labels[1]);
                continue;
            }
        }

        return iphone;
    }
}
