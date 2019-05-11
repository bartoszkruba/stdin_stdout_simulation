package com.company.IO;

import java.io.*;

public class IOHelper {
    private final String stdinFilePath;
    private final String stdoutFilePath;

    private String stdinHeader;
    private String stdoutCommands;

    public IOHelper() {
        stdinFilePath = System.getProperty("user.dir") + File.separator + "stdin";

        // TODO: 2019-05-11 make sure stdin exists
        stdoutFilePath = System.getProperty("user.dir") + File.separator + "stdout";

        System.out.println(stdinFilePath);
        System.out.println(stdoutFilePath);
    }

    public void readStdin() throws IOException {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(stdinFilePath))) {
            stdinHeader = reader.readLine();
            stdoutCommands = reader.readLine();
        }
    }

    public void writeToStdout(String string) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(stdoutFilePath))) {
            writer.write(string);
        }
    }

    public String getStdinHeader() {
        return stdinHeader;
    }

    public void setStdinHeader(String stdinHeader) {
        this.stdinHeader = stdinHeader;
    }

    public String getStdoutCommands() {
        return stdoutCommands;
    }

    public void setStdoutCommands(String stdoutCommands) {
        this.stdoutCommands = stdoutCommands;
    }
}
