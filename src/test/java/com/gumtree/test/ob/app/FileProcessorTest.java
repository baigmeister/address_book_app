package com.gumtree.test.ob.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class FileProcessorTest extends TestUtils {

    private FileContentProcessor fileContentProcessor;

    @Before
    public void init() {
        fileContentProcessor = new FileContentProcessor();
    }

    @Test
    public void processFileLineValid() throws RecordException {
        Optional<AddressBookLine> addressBookLine = fileContentProcessor.processFileLine("Bill McKnight, Male, 16/03/77", 0);
        assertTrue(addressBookLine.isPresent());
        assertFileLine(addressBookLine.get(), "Bill","McKnight"  ,Gender.MALE, 77,3,16 );
    }

    @Test
    public void processFileLineInvalidGender() throws RecordException{
        Optional<AddressBookLine> addressBookLine = fileContentProcessor.processFileLine("Bill McKnight, Invalid, 16/03/77", 0);
        assertFalse(addressBookLine.isPresent());
    }

    @Test
    public void processFileLineInvalidName() {
        Optional<AddressBookLine> addressBookLine = fileContentProcessor.processFileLine("1, Male, 16/03/77", 0);
        assertFalse(addressBookLine.isPresent());
    }

    @Test
    public void processFileLineInvalidDateOfBirthFormat(){
        Optional<AddressBookLine> addressBookLine = fileContentProcessor.processFileLine("Bill McKnight, Male, 16-03-77", 0);
        assertFalse(addressBookLine.isPresent());
    }

    @Test
    public void processFileLineInvalidDateOfBirth(){
        Optional<AddressBookLine> addressBookLine = fileContentProcessor.processFileLine("Bill McKnight, Male, 78/03/77", 0);
        assertFalse(addressBookLine.isPresent());
    }
}
