package com.tk.test_project.service.impl;

import com.tk.test_project.dto.ItemPriceDTO;
import com.tk.test_project.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientServiceImpl implements WebClientService {
    private final String externalServiceURL;
    private final String uri;

    @Autowired
    public WebClientServiceImpl(@Value("${external.service-url}") String externalServiceURL,
                                @Value("${external.price-url-path}") String uri) {
        this.externalServiceURL = externalServiceURL;
        this.uri = uri;
    }

    @Override
    public Mono<ItemPriceDTO> sendHTTPRequestToGetDTO(Long id) {
        WebClient webClient = WebClient.create(externalServiceURL);
        return webClient.get()
                .uri(uri + id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(ItemPriceDTO.class);
    }
}
