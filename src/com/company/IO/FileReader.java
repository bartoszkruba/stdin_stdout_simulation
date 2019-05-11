package com.company.IO;

import java.io.File;

public class FileReader {
    private final String stdinFilePath;
    private final String stdoutFilePath;

    public FileReader() {
        stdinFilePath = System.getProperty("user.dir") + File.separator + "stdin";

        // TODO: 2019-05-11 make sure stdin exists
        stdoutFilePath = System.getProperty("user.dir") + File.separator + "stdin";

        System.out.println(stdinFilePath);
        System.out.println(stdoutFilePath);
    }
}
