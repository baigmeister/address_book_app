package com.gumtree.test.ob.app;

import java.util.List;

public interface AddressBookFinder {

    /**
     *  Gets the number of Males in the address book
     * @param addressBookLineList
     */
    int findNumberOfMales(List<AddressBookLine> addressBookLineList);

    /**
     * Find the oldest person in the address book
     * @param addressBookLineList
     */
    String findOldestPerson(List<AddressBookLine> addressBookLineList);
}
