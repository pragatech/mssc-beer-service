package praga.springframework.msscbeerservice.web.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import praga.springframework.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(
            @PathVariable UUID beerId){
        //todo IMpl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto){
        //todo Impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(
            @Validated @RequestBody BeerDto beerDto,
            @PathVariable UUID beerId
    ){
        //todo Impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
