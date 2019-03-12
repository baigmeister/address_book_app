package com.gumtree.test.ob.app;

import java.util.Comparator;
import java.util.List;

public class AddressBookFinderImpl implements AddressBookFinder {
    /**
     *  Gets the number of Males in the address book
     * @param addressBookLineList
     */
    public int findNumberOfMales(List<AddressBookLine> addressBookLineList) {
        int count = 0;
        if (addressBookLineList != null && !addressBookLineList.isEmpty() ) {
            count = new Long(addressBookLineList.stream().filter(p -> p.getGender().equals(Gender.MALE)).count()).intValue();
        }
        return count;
    }

    /**
     * Find the oldest person in the address book
     * @param addressBookLineList
     */
    public String findOldestPerson(List<AddressBookLine> addressBookLineList) {
        if(addressBookLineList != null && !addressBookLineList.isEmpty()) {
            addressBookLineList.sort(new Comparator<AddressBookLine>() {
                // TODO what if two persons of the same age - possible refactoring
                @Override
                public int compare(AddressBookLine o1, AddressBookLine o2) {
                    return o1.getDateOfBirth().compareTo(o2.getDateOfBirth()) ;
                }
            });
            return addressBookLineList.get(0).getName();
        }
        return null;
    }
}
