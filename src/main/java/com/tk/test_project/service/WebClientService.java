package com.tk.test_project.service;

import com.tk.test_project.dto.ItemPriceDTO;
import reactor.core.publisher.Mono;

public interface WebClientService {
    Mono<ItemPriceDTO> sendHTTPRequestToGetDTO(Long id);
}
