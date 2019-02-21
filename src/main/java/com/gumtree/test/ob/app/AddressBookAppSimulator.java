package com.gumtree.test.ob.app;

import java.util.List;

public class AddressBookAppSimulator {

    private static final String FILE_PATH = "/data/addressbook.txt";

    public static void main(String[] args) {
        AddressBookFileReader addressBookFileReader = new AddressBookFileReader();
        addressBookFileReader.setFileContentProcessor(new FileContentProcessor());
        List<AddressBookLine> addressBookLineList = addressBookFileReader.getAddressBookContents(FILE_PATH);
        System.out.println(String.format("There are %d males in the address book",addressBookFileReader.findNumberOfMales(addressBookLineList)));
        String oldestPersonName = addressBookFileReader.findOldestPerson(addressBookLineList);
        if (oldestPersonName != null) {
            System.out.println(String.format("%s is the oldest person in the address book", oldestPersonName ));
        } else {
            System.out.println("The address book list does not exist ");
        }
    }
}
