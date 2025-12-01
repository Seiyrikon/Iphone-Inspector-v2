package services.device;

import java.util.List;

import utils.Commander;
import utils.Constants;

public class DeviceService {

    Commander commanderService;
    List<String> commands;

    public DeviceService(Commander commanderService) {
        this.commanderService = commanderService;
    }

    public void detect() {
        
        List<String> iphoneInfo = commanderService.runCommand();
    }
}
