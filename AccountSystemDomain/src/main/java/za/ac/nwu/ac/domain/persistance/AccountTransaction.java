package za.ac.nwu.ac.domain.persistance;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Account_Transaction")
public class AccountTransaction implements Serializable
{
    private static final long serialVersUID = -3300948392647393049L;
    private Long transID;
    private Long accTypeID;
    private Long membershipID;
    private Long totalAmount;
    private LocalDate transDate;

    public AccountTransaction(long transID, long accTypeID, long membershipID, long totalAmount, LocalDate transDate)
    {
        setTransactionID(transID);
        setAccountTypeID(accTypeID);
        setAmount(totalAmount);
        setTransDate(transDate);
        setMembershipID(membershipID);
    }

    @Id
    @SequenceGenerator(name = "AccountSystem_Seq", sequenceName = "AccountSystem.AccountSystem_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AccountSystem_SEQ")

    @Column(name = "Transaction_ID")
    public Long getTransactionID()
    {
        return transID;
    }

    @Column(name ="Account_Type_ID")
    public Long getAccountTypeID()
    {
        return accTypeID;
    }

    @Column(name = "Membership_ID")
    public Long getMembershipID()
    {
        return membershipID;
    }

    @Column(name ="Total_Amount")
    public Long getAmount()
    {
        return totalAmount;
    }

    @Column(name = "Transaction_Date")
    public LocalDate getTransDate()
    {
        return transDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "accountTypeID")
    public long getAccountId()
    {
        return accTypeID;
    }

    public void setTransactionID(long transID)
    {
        this.transID = transID ;
    }

    public void setMembershipID(long membershipID)
    {
        this.membershipID = membershipID;
    }

    public void setAccountTypeID(long accTypeID)
    {
        this.accTypeID = accTypeID;
    }

    public void setAmount(long totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public void setTransDate(LocalDate transDate)
    {
        this.transDate = transDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;

        }
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(transID,that.transID) && Objects.equals(accTypeID, that.accTypeID) && Objects.equals(membershipID, that.membershipID )&& Objects.equals(totalAmount, that.totalAmount)&& Objects.equals(transDate, that.transDate);
    }

    @Override
    public String toString()
    {
        return "AccountTransaction{" + "accountTypeID ='"+ accTypeID + '\''+ "transactionID='" + transID + '\'' + ",membershipID='"+ membershipID + '\'' + ", amount=" + totalAmount +'\''+ ",transDate=+" + transDate + "}";
    }
}


