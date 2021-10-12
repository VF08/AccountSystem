package za.ac.nwu.ac.flow;

import za.ac.nwu.ac.domain.dto.*;

import java.util.List;

public interface FetchAccountType {
    List<AccountTypeDto> getAllAccounTypes();
    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
}
