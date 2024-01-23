package Enums.WebElementEnums;

public enum RegisterPageEnums {
    MaleRadioFieldClass("male"),
    FirstNameInputFieldName("FirstName"),
    LastNameInputFieldName("LastName"),
    DayDropdownName("DateOfBirthDay"),
    MonthDropdownName("DateOfBirthMonth"),
    YearDropdownName("DateOfBirthYear"),
    EmailInputFieldName("Email"),
    PasswordInputFieldName("Password"),
    ConfirmPasswordInputFieldName("ConfirmPassword");


    public final String value;
    RegisterPageEnums(String name) {
        this.value = name;
    }
}