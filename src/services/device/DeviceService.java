package services.device;

import java.util.List;

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

    public CommandResult extractInfo() {
        CommandResult result = CommandExecutor.runTool(Constants.IDEVICE_INFO.get().toString());

        if (result.output.isBlank()) {
            System.out.println("No Information to display");
        } else {
            System.out.println("Information is displayed");
        }

        return result;
    }
}
