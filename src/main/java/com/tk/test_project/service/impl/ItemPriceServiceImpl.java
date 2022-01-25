package com.tk.test_project.service.impl;

import com.tk.test_project.dto.ItemPriceDTO;
import com.tk.test_project.service.ItemPriceService;
import com.tk.test_project.service.WebClientService;
import com.tk.test_project.utils.FloatFieldRounder;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class ItemPriceServiceImpl implements ItemPriceService {
    private final WebClientService webClientService;

    @Override
    @Cacheable(value = "itemPriceCache")
    public ItemPriceDTO getItemPrice(Long id) {
        try {
            return webClientService.sendHTTPRequestToGetDTO(id).block();
        } catch (Exception e) {
            //Method will definitely throw UnknownHostException as the URL to which the request is sent is not valid
            //The exception could be handled by ControllerExceptionHandler
            //This is a stub for returning the value so that the further flow could be checked
            return ItemPriceDTO.builder()
                    .itemPrice(FloatFieldRounder.roundFloatField(new Random().nextFloat())).build();
        }
    }
}
