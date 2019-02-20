package com.gumtree.test.ob;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.is;

@RunWith(JUnit4.class)
public class AddressBookFileReaderTest {

    private static final String VALID_FILE_PATH = "/data/valid_addressbook.txt";
    private AddressBookFileReader addressBookFileReader;

    @Test
    public void testGetFileContentsValid() {
        addressBookFileReader = new AddressBookFileReader();
        addressBookFileReader.setFileContentProcessor(new FileContentProcessor());
        List<AddressBookLine> addressBookLineList = addressBookFileReader.getAddressBookContents(VALID_FILE_PATH);
        assertThat(addressBookLineList.size(), is(2));
    }
}
