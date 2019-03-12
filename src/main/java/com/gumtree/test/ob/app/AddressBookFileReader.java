package com.gumtree.test.ob.app;

import java.io.*;
import java.util.*;

public class AddressBookFileReader {

    private FileContentProcessor fileContentProcessor;

    /**
     * Gets Address Book contents from AddressBook file
     * @param filePath
     * @return
     */
    public List<AddressBookLine> getAddressBookContents(String filePath) {
        List<AddressBookLine> fileContents = null;
        if (filePath != null) {
            try {
                fileContents = getFileContents(filePath);
            } catch (IOException io) {
                System.out.println("Error in getFileContents: " + io.getMessage());
            }
        }
        return fileContents;
    }

    private List<AddressBookLine> getFileContents(String path) throws IOException {

        InputStream inputStream = getClass().getResourceAsStream(path);
        List<AddressBookLine> addressBookLines = new ArrayList<>();
        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)));
            String line = "";
            int lineCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                Optional<AddressBookLine> addressBookLine = fileContentProcessor.processFileLine(line, lineCount);
                // TODO Assumption: data is rejected when a single line is found to be invalid - debugging could be added to highlight line number of invalid data
                if (addressBookLine.isPresent()) {
                    addressBookLines.add(addressBookLine.get());
                } else {
                    break;
                }
                lineCount++;
            }
        }
        return addressBookLines;
    }

    public void setFileContentProcessor(FileContentProcessor fileContentProcessor) {
        this.fileContentProcessor = fileContentProcessor;
    }
}
