package com.gumtree.test.ob;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnit4.class)
public class AddressBookFileReaderTest extends TestUtils {

    private static final String FILE_PATH_VALID_DATA = "/data/valid_addressbook.txt";
    private static final String FILE_PATH_INVALID_DATA = "/data/invalid_addressbook.txt";
    private AddressBookFileReader addressBookFileReader;

    @Before
    public void init() {
        addressBookFileReader = new AddressBookFileReader();
        addressBookFileReader.setFileContentProcessor(new FileContentProcessor());
    }

    @Test
    public void testGetFileContentsValid() {
        List<AddressBookLine> addressBookLineList = addressBookFileReader.getAddressBookContents(FILE_PATH_VALID_DATA);
        assertThat(addressBookLineList.size(), is(2));
        assertFileLine(addressBookLineList.get(0), "Bill", "McKnight", Gender.MALE,1977, 3, 16);
        assertFileLine(addressBookLineList.get(1), "Paul", "Robinson", Gender.MALE, 1985, 1,15);
    }

    @Test
    public void testGetFileContentsInvalid() {
        List<AddressBookLine> addressBookLineList = addressBookFileReader.getAddressBookContents(FILE_PATH_INVALID_DATA);
        assertThat(addressBookLineList.size(), is(0));
    }

    @Test
    public void findNumberOfMalesValid() {
        assertThat(addressBookFileReader.findNumberOfMales(getAddressBookList()), is(2));
    }

    @Test
    public void findOldestPersonValid() {
        assertThat(addressBookFileReader.findOldestPerson(getAddressBookList()), is("Bill Knight"));
    }

    private List<AddressBookLine> getAddressBookList() {
        List<AddressBookLine> addressBookLineList = new ArrayList<>();
        addressBookLineList.add(buildAddressLine("Bill", "Knight", Gender.MALE, 1977, 3, 16));
        addressBookLineList.add(buildAddressLine("Paul", "Robinson", Gender.MALE, 1985, 1,15));
        addressBookLineList.add(buildAddressLine("Gemma", "Lane", Gender.FEMALE, 1991, 11, 20));
        return addressBookLineList;
    }


}
