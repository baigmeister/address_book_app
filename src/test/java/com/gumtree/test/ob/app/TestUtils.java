package com.gumtree.test.ob.app;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestUtils {

    protected void assertFileLine(AddressBookLine addressBookLine, String firstName, String familyName, Gender gender, int year, int month, int day) {
        Calendar dateOfBirth = addressBookLine.getDateOfBirth();
        assertThat(addressBookLine.getFirstName(), is(firstName));
        assertThat(addressBookLine.getFamilyName(), is(familyName));
        assertThat(dateOfBirth.get(Calendar.YEAR), is(year) );
        assertThat(dateOfBirth.get(Calendar.MONTH), is(month-1));
        assertThat(dateOfBirth.get(Calendar.DATE), is(day));
    }

    protected AddressBookLine buildAddressLine(String firstName, String familyName, Gender gender, int year, int month, int day) {
        AddressBookLine addressBookLine = new AddressBookLine();
        addressBookLine.setGender(gender);
        addressBookLine.setDateOfBirth(getDateOfBirth(year, month, day));
        addressBookLine.setFirstName(firstName);
        addressBookLine.setFamilyName(familyName);
        return  addressBookLine;
    }

    private Calendar getDateOfBirth(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month -1, day);
        return cal;
    }
}
