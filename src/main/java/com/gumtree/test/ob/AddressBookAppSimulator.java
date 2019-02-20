package com.gumtree.test.ob;

import java.util.List;

public class AddressBookAppSimulator {

    private static final String FILE_PATH = "/data/addressbook.txt";

    public static void main(String[] args) {
        AddressBookFileReader addressBookFileReader = new AddressBookFileReader();
        addressBookFileReader.setFileContentProcessor(new FileContentProcessor());
        List<AddressBookLine> addressBookLineList = addressBookFileReader.getAddressBookContents(FILE_PATH);

        System.out.println("end");



    }
}
