package com.gumtree.test.ob.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnit4.class)
public class AddressBookFileReaderTest extends TestUtils {

    private static final String FILE_PATH_VALID_DATA = "/data/valid_addressbook.txt";
    private static final String FILE_PATH_INVALID_DATA = "/data/invalid_addressbook.txt";
    private static final String FILE_PATH_EMPTY_DATA = "/data/empty_addressbook.txt";
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
    public void testGetFileContentsWithEmptyAddressList() {
        List<AddressBookLine> addressBookLineList = addressBookFileReader.getAddressBookContents(FILE_PATH_EMPTY_DATA);
        assertThat(addressBookLineList.size(), is(0));
    }

    @Test
    public void testGetFileContentsWithNullFilePath() {
        List<AddressBookLine> addressBookLineList = addressBookFileReader.getAddressBookContents(null);
        assertNull(addressBookLineList);
    }

    @Test
    public void testGetFileContentsWithInvalidPath() {
        List<AddressBookLine> addressBookLineList = addressBookFileReader.getAddressBookContents("invalid");
        assertThat(addressBookLineList.size(), is(0));
    }

    @Test
    public void findNumberOfMalesValid() {
        assertThat(addressBookFileReader.findNumberOfMales(getAddressBookList()), is(2));
    }

    @Test
    public void findNumberOfMalesWithNullAddressBookList() {
        assertThat(addressBookFileReader.findNumberOfMales(null), is(0));
    }

    @Test
    public void findNumberOfMalesWithEmptyAddressBookList() {
        List<AddressBookLine> addressBookLineList = new ArrayList<>();
        assertThat(addressBookFileReader.findNumberOfMales(addressBookLineList), is(0));
    }

    @Test
    public void findOldestPersonValid() {
        assertThat(addressBookFileReader.findOldestPerson(getAddressBookList()), is("Bill Knight"));
    }

    @Test
    public void findOldestPersonWithNullAddressBookList() {
        assertNull(addressBookFileReader.findOldestPerson(null));
    }

    @Test
    public void findOldestPersonWithEmptyAddressBookList() {
        List<AddressBookLine> addressBookLineList = new ArrayList<>();
        assertNull(addressBookFileReader.findOldestPerson(addressBookLineList));
    }

    private List<AddressBookLine> getAddressBookList() {
        List<AddressBookLine> addressBookLineList = new ArrayList<>();
        addressBookLineList.add(buildAddressLine("Bill", "Knight", Gender.MALE, 1977, 3, 16));
        addressBookLineList.add(buildAddressLine("Paul", "Robinson", Gender.MALE, 1985, 1,15));
        addressBookLineList.add(buildAddressLine("Gemma", "Lane", Gender.FEMALE, 1991, 11, 20));
        return addressBookLineList;
    }
}
