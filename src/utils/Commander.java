package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Commander {

    public List<String> runCommand(String... cmd) {
        List<String> result = null;
        String line = null;
        int exitCode = 0;
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            result = new ArrayList<>();

            while((line = reader.readLine()) != null) {
                result.add(line);
            }

            exitCode = process.waitFor();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return result;
    }
}
