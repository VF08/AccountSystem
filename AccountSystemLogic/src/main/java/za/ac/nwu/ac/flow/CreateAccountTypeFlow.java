package za.ac.nwu.ac.flow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.translator.Impl.AccountTranslator;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.flow.CreateAccountType;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("CreateAccountTypeFlowName")
public class CreateAccountTypeFlow implements CreateAccountType{
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTypeFlow.class);

    private final AccountTranslator accountTranslator;

    public CreateAccountTypeFlow(AccountTranslator accountTranslator)
    {
        this.accountTranslator = accountTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType)
    {
        LOGGER.info("This create Object{}",accountType);

        if (null == accountType.getCreationDate())
        {
            accountType.setCreationDate(LocalDate.now());
            LOGGER.info("The creation date was created{}", accountType.getCreationDate());
        }
        AccountTypeDto results = accountTranslator.create(accountType);
        LOGGER.info("The results of creation Date{}", results);
        return results;
    }

}
