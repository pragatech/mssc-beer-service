package praga.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import praga.springframework.msscbeerservice.web.model.BeerDto;
import praga.springframework.msscbeerservice.web.model.BeerStyleEnum;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        //Perform will create input requst. Ln btwn 23 to 26
        mockMvc.perform(
                        get("/api/v1/beer/"+UUID.randomUUID())
                            .accept(MediaType.APPLICATION_JSON)
                )
                //matching result/output of rest call
                .andExpect(
                        status().isOk()
                );
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerJsonStr = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(
                    post("/api/v1/beer")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerJsonStr)
        ).
                andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = getValidBeerDto();
        String beerJsonStr = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(
                    put("/api/v1/beer/"+UUID.randomUUID())
                            .content(beerJsonStr)
                            .contentType(MediaType.APPLICATION_JSON)
        ).
                andExpect(status().isNoContent());
    }

    BeerDto getValidBeerDto(){
        System.out.println(BeerStyleEnum.ALE);
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(123123123123L)
                .build();
    }
}