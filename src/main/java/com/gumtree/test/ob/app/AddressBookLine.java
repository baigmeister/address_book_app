package com.gumtree.test.ob.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;

public class AddressBookLine {

    private String firstName;
    private String familyName;
    private Gender gender;
    private LocalDate dateOfBirth;

    private int count;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getLineNumber() {
        return count;
    }

    public void setLineNumber(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "AddressBookLine{" +
                "firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }

    public String getName() {
        return firstName + " " + familyName;
    }

    public void setProperties(Optional<String> firstName, Optional<String> familyName, Optional<Gender> gender, Optional<LocalDate> localDate) throws RecordException {
        if (firstName.isPresent()) {
            this.firstName = firstName.get();
        } else {
            throw new RecordException("FirstName is invalid");
        }
        this.familyName = familyName.orElse("");
        if(gender.isPresent()) {
            this.gender = gender.get();
        } else {
            throw new RecordException("Gender is invalid");
        }
        if(localDate.isPresent()) {
            this.dateOfBirth = localDate.get();
        } else {
            throw new RecordException("DoB is invalid");
        }
    }
}
