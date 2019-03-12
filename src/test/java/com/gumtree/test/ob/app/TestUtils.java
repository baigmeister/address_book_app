package com.gumtree.test.ob.app;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.junit.Test;
import java.time.LocalDate;
import java.util.Optional;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestUtils {

    protected void assertFileLine(AddressBookLine addressBookLine, String firstName, String familyName, Gender gender, int year, int month, int day) {
        LocalDate dateOfBirth = addressBookLine.getDateOfBirth();
        assertThat(addressBookLine.getFirstName(), is(firstName));
        assertThat(addressBookLine.getFamilyName(), is(familyName));
        assertThat(String.valueOf(dateOfBirth.getYear()).substring(2,4), is(String.valueOf(year)) );
        assertThat(dateOfBirth.getMonth().getValue(), is(month));
        assertThat(dateOfBirth.getDayOfMonth(), is(day));
    }

    protected AddressBookLine buildAddressLine(String firstName, String familyName, Gender gender, int year, int month, int day) {
        AddressBookLine addressBookLine = new AddressBookLine();
        addressBookLine.setGender(gender);
        addressBookLine.setDateOfBirth(getDateOfBirth(year, month, day));
        addressBookLine.setFirstName(firstName);
        addressBookLine.setFamilyName(familyName);
        return  addressBookLine;
    }

    private LocalDate getDateOfBirth(int year, int month, int day) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }

    // Misc
    @Test
    public void testOptional() {
        Optional<String> test = Optional.empty();
        String hello = "hello";
        test = Optional.ofNullable(hello);
        System.out.println(test.get());
    }
    @Test
    public void testInt(){

        int result = 33%40;
        System.out.println("" +result);
    }
    @Test
    public void rangeTest() {
        int[] range = new int[]{1,3,4,5};
        int s = 4;
        int t = 1;


    }

}


