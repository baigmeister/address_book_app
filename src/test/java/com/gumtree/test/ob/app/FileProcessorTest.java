package com.gumtree.test.ob.app;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class FileProcessorTest extends TestUtils {

    private FileContentProcessor fileContentProcessor;

    @Before
    public void init() {
        fileContentProcessor = new FileContentProcessor();
    }

    @Test
    public void processFileLineValid() {
        AddressBookLine addressBookLine = fileContentProcessor.processFileLine("Bill McKnight, Male, 16/03/77", 0);
        assertNotNull(addressBookLine);
        assertFileLine(addressBookLine, "Bill","McKnight"  ,Gender.MALE, 1977,3,16 );
    }

    @Test
    public void processFileLineInvalidGender() {
        AddressBookLine addressBookLine = fileContentProcessor.processFileLine("Bill McKnight, Invalid, 16/03/77", 0);
        assertNull(addressBookLine);
    }

    @Test
    public void processFileLineInvalidName() {
        AddressBookLine addressBookLine = fileContentProcessor.processFileLine("1, Male, 16/03/77", 0);
        assertNull(addressBookLine);
    }

    @Test
    public void processFileLineInvalidDateOfBirthFormat(){
        AddressBookLine addressBookLine = fileContentProcessor.processFileLine("Bill McKnight, Male, 16-03-77", 0);
        assertNull(addressBookLine);
    }

    @Ignore
    @Test
    // TODO Refactor Date of Birth Functionality - invalid date of birth is accepted
    public void processFileLineInvalidDateOfBirth(){
        AddressBookLine addressBookLine = fileContentProcessor.processFileLine("Bill McKnight, Male, 78/03/77", 0);
        assertNull(addressBookLine);
    }
}
