package com.gumtree.test.ob.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class FileContentProcessor {

    private static final String DATE_FORMAT = "dd/MM/yy" ;

    /**
     *  Validates firstName, familyName, gender (Male, Female), dateOfBirth and Builds AddressBookLine Objects
     * @param line String - input file line
     * @return <Optional>AddressBookLine
     */
    public Optional<AddressBookLine> processFileLine(String line, int count)  {
        Optional<AddressBookLine> addressBookLineResult = Optional.empty();
        AddressBookLine addressBookLine = new AddressBookLine();
        String[] fields = line.split(", ");
        if (fields.length != 3) {
            return null;
        }
        Optional<String> firstName = extractName(fields[0], 0);
        Optional<String> familyName = extractName(fields[0], 1);
        Optional<Gender> gender = extractGender(fields[1]);
        Optional<LocalDate> localDate =  extractDateOfBirth( fields[2]);

        try {

            addressBookLine.setProperties(firstName, familyName, gender, localDate);
            addressBookLineResult = Optional.of(addressBookLine);
        } catch (RecordException re) {
            System.out.println("Error thrown on line (" + count + ") " + re );

        }
        return  addressBookLineResult;
    }

    private Optional<String> extractName(String nameString, int index) {
        String[] names = nameString.split(" ");
        // TODO Clarification
        Optional<String> name = Optional.empty();
        if (names.length == 2) {
            name = Optional.ofNullable(names[index]);
        }
        return name;
    }

    private Optional<Gender> extractGender(String field) {
        Optional<Gender> gender = Optional.empty();
        switch (field) {
            case "Male" :
                gender = Optional.of(Gender.MALE);
                break;
            case "Female" :
                gender = Optional.of(Gender.FEMALE);
                break;
        }
        return gender;
    }

    private Optional<LocalDate> extractDateOfBirth(String field) {
        Optional<LocalDate> resultLocalDate = Optional.empty();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        try {
            resultLocalDate = Optional.ofNullable(
                    LocalDate.parse(field, formatter));
        } catch (DateTimeParseException de) {
            System.out.println("Date parsing exception: " + de.getMessage());
        }
        return resultLocalDate;
    }
}