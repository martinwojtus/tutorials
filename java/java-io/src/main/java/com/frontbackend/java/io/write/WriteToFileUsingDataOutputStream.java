package com.frontbackend.java.io.write;

import java.io.*;

public class WriteToFileUsingDataOutputStream {

    public static void main(String[] args) throws IOException {
        String fileContent = "FrontBackend.com";

        FileOutputStream outputStream = new FileOutputStream("/tmp/test4.txml");
        DataOutputStream dataOutStream = new DataOutputStream(new BufferedOutputStream(outputStream));
        dataOutStream.writeUTF(fileContent);

        dataOutStream.close();
    }
}
