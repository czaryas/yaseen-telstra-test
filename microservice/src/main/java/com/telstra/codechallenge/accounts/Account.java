package com.telstra.codechallenge.accounts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Account {

    private Long id;
    private String login;
    @JsonProperty("html_url")
    private String htmlUrl;
}
