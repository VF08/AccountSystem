package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistance.AccountType;

@Repository
public interface AccountTypeRep extends  JpaRepository<AccountType, Long> {
    @Query(value = "SELECT" +
            "     ACCOUNT_TYPE_ID,"+
            "     ACCOUNT_TYPE_NAME," +
            "     CREATION_DATE,"+
            "     MNEMONIC" +
            "  FROM" +
            "      ACCOUNT_TYPE" +
            " WHERE MNEMONIC = : mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
}
