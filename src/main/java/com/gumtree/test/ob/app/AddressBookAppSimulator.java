package com.gumtree.test.ob.app;

import java.util.List;

public class AddressBookAppSimulator {

    private static final String FILE_PATH = "/data/addressbook.txt";

    public static void main(String[] args) {
        AddressBookFileReader addressBookFileReader = new AddressBookFileReader();

        // TO DO decouple
        addressBookFileReader.setFileContentProcessor(new FileContentProcessor());

        List<AddressBookLine> addressBookLineList = addressBookFileReader.getAddressBookContents(FILE_PATH);
        AddressBookFinder addressBookFinder = new AddressBookFinderImpl();
        System.out.println(String.format("There are %d males in the address book",addressBookFinder.findNumberOfMales(addressBookLineList)));
        String oldestPersonName = addressBookFinder.findOldestPerson(addressBookLineList);
        if (oldestPersonName != null) {
            System.out.println(String.format("%s is the oldest person in the address book", oldestPersonName ));
        } else {
            System.out.println("The address book list does not exist ");
        }
    }
}
