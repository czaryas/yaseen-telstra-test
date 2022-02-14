package com.telstra.codechallenge.accounts;

import com.telstra.codechallenge.quotes.Quote;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SpringBootAccountsService {
    public List getAccounts(Integer numberOfAccounts);
}
