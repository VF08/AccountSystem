package za.ac.nwu.ac.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.ac.translator.Impl.AccountTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlow implements FetchAccountType{
    private final AccountTranslator accountTranslator;

    @Autowired
    public FetchAccountTypeFlow(AccountTranslator accountTranslator)
    {
        this.accountTranslator = accountTranslator;
    }

    public List<AccountTypeDto> getAllAccountypes() {

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        accountTypeDtos.add(new AccountTypeDto("MILES","miles", LocalDate.now()));
        return accountTypeDtos;
    }

    @Override
    public List<AccountTypeDto> getAllAccounTypes() {
        return null;
    }

    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic)
    {
        return accountTranslator.getAccountTypeByMnemonicNativeQuery(mnemonic);
    }
}
