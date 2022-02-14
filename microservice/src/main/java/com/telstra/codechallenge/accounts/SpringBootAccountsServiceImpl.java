package com.telstra.codechallenge.accounts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpringBootAccountsServiceImpl implements SpringBootAccountsService{
    public static final String SEARCH_QUERY_PARAM_Q = "q";
    public static final String SORT_ORDER = "order";
    public static final String SORT_ORDER_VALUE = "desc";
    public static final String SORT_FILTER_JOIN = "joined";
    public static final String SORT_FILTER_TYPE = "sort";
    public static final String ZERO_FOLLOWERS = "followers:0";
    public static final String PER_PAGE = "per_page";
    public static final String PAGE_NO = "page";
    public static final int MAX_ITEMS = 100;

    @Value("${github.base.url}")
    private String githubBaseUrl;

    private RestTemplate restTemplate;

    public SpringBootAccountsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List getAccounts(Integer numberOfAccounts) {

        List accounts = new ArrayList();
        int pages = numberOfAccounts/MAX_ITEMS;
        int remainder = numberOfAccounts % MAX_ITEMS;
        for (int i = 1; i <= pages; i++) {
            accounts.addAll(getAccounts(MAX_ITEMS, i));
        }
        if(remainder > 0){
            accounts.addAll(getAccounts(remainder, (pages+1)));
        }
        return accounts;
    }


    private List<Account> getAccounts(int perPage, int pageNo){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(githubBaseUrl)
                .queryParam(SEARCH_QUERY_PARAM_Q, ZERO_FOLLOWERS)
                .queryParam(SORT_ORDER, SORT_ORDER_VALUE)
                .queryParam(SORT_FILTER_TYPE, SORT_FILTER_JOIN)
                .queryParam(PER_PAGE, perPage)
                .queryParam(PAGE_NO, pageNo);

        SearchResponse response = restTemplate.getForObject(builder.build(true).toUriString(), SearchResponse.class);
        return response.getItems();

    }
}
