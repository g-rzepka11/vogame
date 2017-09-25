package com.vogame.services;

import com.vogame.beans.LongmanResponse;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LongmanService {
  public LongmanResponse getLongmanDefinition(String word) {
    RestTemplate restTemplate = new RestTemplate();

    LongmanResponse longmanResponse = restTemplate
              .getForObject("http://api.pearson.com/v2/dictionaries/lasde/entries?headword=" + word,
                      LongmanResponse.class);

    return longmanResponse;
  }
}
