package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistance.AccountType;

import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Account_Type", description = "A Dto that represents the Account_Type")

public class AccountTypeDto {

    private static final long serialVersUID = -3300948392647393049L;
    private String mnemonic;
    private String accTypeName;
    private LocalDate creationDate;

    public AccountTypeDto(String mnemonic, String accTypeName, LocalDate creationDate) {
        setMnemonic(mnemonic);
        setAccTypeName(accTypeName);
        setCreationDate(creationDate);
    }

    public void setMnemonic(String mnemonic)
    {
        this.mnemonic = mnemonic;
    }

    public void setAccTypeName(String accTypeName)
    {
        this.accTypeName = accTypeName;
    }

    public void setCreationDate(LocalDate creationDate)
    {
        this.creationDate = creationDate;
    }

    @ApiModelProperty(position = 1, value = "AccountType Name", name = "Account_Type_Name", notes = "the account type name", dataType = "Java.lang.String", example = "MILES", allowEmptyValue = false, required = true)

    public String getAccTypeName()
    {
        return accTypeName;
    }

    @ApiModelProperty(position = 2, value = "AccountType mnemonic", name = "Mnemonic", notes = "Uniquely identifiers the account type", dataType = "Java.lang.String", example = "MILES", required = true)

    public String getMnemonic()
    {
        return mnemonic;
    }

    @ApiModelProperty(position = 3, value = "AccountType CreationDate", name = "CreationDate", notes = "This is the date on which AccountType was created", dataType = "Java.lang.String", example = "2021-04-05", allowEmptyValue = true, required = false)

    public LocalDate getCreationDate()
    {
        return creationDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccountTypeDto that = (AccountTypeDto) obj;

        return Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accTypeName, that.accTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @JsonIgnore
    public AccountType getAccountType()
    {
        return new AccountType(getAccountType().getAccTypeID(), getAccTypeName(), getMnemonic(), getCreationDate());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mnemonic, accTypeName, creationDate);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" + "mnemonic= '" + mnemonic + '\'' + ",accountTypeName= '" + accTypeName + '\'' + ", creationDate=" + creationDate + "}";

    }
}