package com.telstra.codechallenge.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SearchResponse {

    List<Account> items;
}
