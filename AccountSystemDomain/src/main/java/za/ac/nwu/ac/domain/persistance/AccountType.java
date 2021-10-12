package za.ac.nwu.ac.domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Account_Type")

public class AccountType implements Serializable{

    private static final long serialVersUID = -3300948392647393049L;
    private Long accTypeID;
    private String accTypeName;
    private String mnemonic;
    private LocalDate creationDate;
    private  Set<AccountTransaction> accTransaction;

    public AccountType(long accTypeID, String accTypeName, String mnemonic, LocalDate creationDate) {
        setAccTypeID(accTypeID);
        setAccTypeName(accTypeName);
        setMnemonic(mnemonic);
        setCreationDate(creationDate);
    }

    @Id
    @SequenceGenerator(name = "AccountSystem_Sequence", sequenceName = "AccountSystem.AccountSystem_Seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountSystem_Seq")

    @Column(name = "Account_Type_ID")
    public long getAccTypeID()
    {
        return accTypeID;
    }

    @Column(name = "Account_Type_Name")
    public  String getAccTypeName()
    {
        return accTypeName;
    }

    @Column(name = "Mnemobic")
    public String getMnemonic()
    {
        return mnemonic;
    }

    @Column(name = "Creation_Date")
    public LocalDate getCreationDate()
    {
        return creationDate;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY,mappedBy = "accountTypeID", orphanRemoval = true,cascade = CascadeType.PERSIST)
    public Set<AccountTransaction>getAccTransaction()
    {
        return accTransaction;
    }

    public void setAccTypeID(long accTypeID)
    {
        this.accTypeID = accTypeID;
    }

    public void setAccTypeName(String accTypeName)
    {
        this.accTypeName = accTypeName;
    }

    public void setMnemonic(String mnemonic)
    {
        this.mnemonic = mnemonic;
    }

    public void setCreationDate(LocalDate creation_Date)
    {
        this.creationDate = creation_Date;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;

        }
        AccountType that = (AccountType) obj;
        return Objects.equals(mnemonic,that.mnemonic) && Objects.equals(accTypeName, that.accTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    public String toString()
    {
        return "AccountType{" + "accountTypeID ='"+ accTypeID + '\''+ "mnemonic='" + mnemonic + '\'' + ",AccountTypeName='"+ accTypeName + '\'' + ", creation_Date=" + creationDate + "}";
    }


}

