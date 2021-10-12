package za.ac.nwu.ac.translator.Impl;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.util.List;


public interface AccountTranslator {
    List<AccountTypeDto> getAllAccounts();

    AccountTypeDto create(AccountTypeDto accountTypeDto);

    AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);

}
