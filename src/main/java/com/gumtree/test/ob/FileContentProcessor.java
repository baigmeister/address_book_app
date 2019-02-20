package com.gumtree.test.ob;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileContentProcessor {

    private static final String DATE_FORMAT = "dd/MM/yy" ;

    /**
     *  Validates firstName, familyName, gender (Male, Female), dateOfBirth and Builds AddressBookLine Objects
     * @param line String - input file line
     * @return AddressBookLine
     */
    public AddressBookLine processFileLine(String line, int count) {
        AddressBookLine addressBookLine = new AddressBookLine();
        String[] fields = line.split(", ");
        if (fields.length != 3) {
            return null;
        }
        addressBookLine = extractNames(addressBookLine, fields[0]);
        if (addressBookLine != null) {
            addressBookLine = extractGender(addressBookLine, fields[1]);
        }
        if (addressBookLine != null) {
            addressBookLine = extractDateOfBirth(addressBookLine, fields[2]);
        }
        if(addressBookLine != null) {
            addressBookLine.setLineNumber(count);
        }
        return  addressBookLine;
    }

    private AddressBookLine extractNames(AddressBookLine addressBookLine, String nameString) {
        String[] names = nameString.split(" ");
        // TODO Clarification - strict approach taken - first name and family name have to be populated
        if (names.length == 2) {
            addressBookLine.setFirstName(names[0]);
            addressBookLine.setFamilyName(names[1]);
        } else {
            addressBookLine = null;
        }
        return addressBookLine;
    }

    private AddressBookLine extractGender(AddressBookLine addressBookLine, String field) {
        Gender gender = null;
        switch (field) {
            case "Male" :
                gender = Gender.MALE;
                break;
            case "Female" :
                gender = Gender.FEMALE;
                break;
        }
        if(gender != null) {
            addressBookLine.setGender(gender);
        } else {
            addressBookLine = null;
        }
        return addressBookLine;
    }

    private AddressBookLine extractDateOfBirth(AddressBookLine addressBookLine, String field) {
        Calendar cal = Calendar.getInstance();
        Pattern pattern = Pattern.compile("\\d\\d/\\d\\d/\\d\\d");
        Matcher matcher = pattern.matcher(field);
        if(matcher.find() ){
            String[] dateFields = field.split("/");
            // TODO Refactor to remove hardcoding for year
            cal.set(getInt("19" + dateFields[2]), getInt(dateFields[1])-1, getInt(dateFields[0]));
        } else {
            cal = null;
        }
        if(cal != null) {
            addressBookLine.setDateOfBirth(cal);
        } else {
            addressBookLine = null;
        }
        return addressBookLine;
    }

    private int getInt(String dateField) {
        return Integer.parseInt(dateField);
    }
}