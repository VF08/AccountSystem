package za.ac.nwu.ac.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.translator.Impl.AccountTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyAccountTypeFlow {
    private final AccountTranslator accountTranslator;

    public ModifyAccountTypeFlow(AccountTranslator accountTranslator)
    {
        this.accountTranslator = accountTranslator;
    }
}
