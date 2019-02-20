package com.gumtree.test.ob;

import java.util.Calendar;

public class AddressBookLine {

    private String firstName;
    private String familyName;
    private Gender gender;
    private Calendar dateOfBirth;

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

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
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
}
