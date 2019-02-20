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
            // TODO Assumption: data is rejected when a single line is found to be invalid - debugging could be added to highlight line number of invalid data
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

    /**
     *  Gets the number of Males in the address book
     * @param addressBookLineList
     */
    public int findNumberOfMales(List<AddressBookLine> addressBookLineList) {
        return new Long(addressBookLineList.stream().filter(p -> p.getGender().equals(Gender.MALE)).count()).intValue();
    }

    /**
     * Find the oldest person in the address book
     * @param addressBookLineList
     */
    public String findOldestPerson(List<AddressBookLine> addressBookLineList) {

        addressBookLineList.sort(new Comparator<AddressBookLine>() {
            // TODO what if two persons of the same age - possible refactoring
            @Override
            public int compare(AddressBookLine o1, AddressBookLine o2) {
                return o1.getDateOfBirth().after(o2.getDateOfBirth()) ? 1 : -1;
            }
        });
        return addressBookLineList.get(0).getName();
    }
}
