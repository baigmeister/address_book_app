package com.gumtree.test.ob;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileReader {

    private FileContentProcessor fileContentProcessor;

    /**
     * Gets Address Book contents from AddressBook file
     * @param filePath
     * @return
     */
    public List<AddressBookLine> getAddressBookContents(String filePath) {
        List<AddressBookLine> fileContents = null;
        try {
            fileContents = getFileContents(filePath);
        } catch (IOException io) {
            System.out.println("Error in getFileContents: " + io.getMessage());
        }
        return fileContents;
    }

    private List<AddressBookLine> getFileContents(String path) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)));
        List<AddressBookLine> addressBookLines = new ArrayList<>();
        String line = "";
        int lineCount = 0;
        while ((line = bufferedReader.readLine()) != null) {
            AddressBookLine addressBookLine = fileContentProcessor.processFileLine(line, lineCount);
            if (addressBookLine == null){
                break;
            }
            addressBookLines.add(addressBookLine);
            lineCount++;
        }
        return addressBookLines;
    }

    public FileContentProcessor getFileContentProcessor() {
        return fileContentProcessor;
    }

    public void setFileContentProcessor(FileContentProcessor fileContentProcessor) {
        this.fileContentProcessor = fileContentProcessor;
    }
}
