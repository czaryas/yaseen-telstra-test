package com.telstra.codechallenge.accounts;

import com.telstra.codechallenge.quotes.Quote;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class SpringBootsAccountsController {

    private SpringBootAccountsService springBootAccountsService;

    public SpringBootsAccountsController(SpringBootAccountsService springBootAccountsService) {
        this.springBootAccountsService = springBootAccountsService;
    }

    @RequestMapping(path = "/oldestAccounts/{numberOfAccounts}", method = RequestMethod.GET)
    public List<Account> quotes(@PathVariable Integer numberOfAccounts) {
        if(Objects.isNull(numberOfAccounts)|| numberOfAccounts == 0 ){
            return Collections.emptyList();
        }
        return (List<Account>) springBootAccountsService.getAccounts(numberOfAccounts);
    }
}
