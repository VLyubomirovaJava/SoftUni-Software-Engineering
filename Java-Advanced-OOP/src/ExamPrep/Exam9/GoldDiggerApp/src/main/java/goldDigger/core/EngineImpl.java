//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package goldDigger.core;

import goldDigger.common.Command;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        while(true) {
            String result = null;

            try {
                result = this.processInput();
                if (result.equals(Command.Exit.name())) {
                    return;
                }
            } catch (IllegalArgumentException | IOException | NullPointerException var3) {
                result = var3.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");
        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = (String[])Arrays.stream(tokens).skip(1L).toArray((x$0) -> {
            return new String[x$0];
        });
        switch (command) {
            case AddDiscoverer:
                result = this.addDiscoverer(data);
                break;
            case AddSpot:
                result = this.addSpot(data);
                break;
            case ExcludeDiscoverer:
                result = this.excludeDiscoverer(data);
                break;
            case InspectSpot:
                result = this.inspectSpot(data);
                break;
            case GetStatistics:
                result = this.getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
        }

        return result;
    }

    private String excludeDiscoverer(String[] data) {
        return this.controller.excludeDiscoverer(data[0]);
    }

    private String getStatistics() {
        return this.controller.getStatistics();
    }

    private String inspectSpot(String[] data) {
        return this.controller.inspectSpot(data[0]);
    }

    private String addSpot(String[] data) {
        String spotName = data[0];
        String[] exhibits = (String[])Arrays.stream(data).skip(1L).toArray(String[]::new);
        return this.controller.addSpot(spotName, exhibits);
    }

    private String addDiscoverer(String[] data) {
        return this.controller.addDiscoverer(data[0], data[1]);
    }
}
