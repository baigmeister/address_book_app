package com.gumtree.test.ob;

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
}
