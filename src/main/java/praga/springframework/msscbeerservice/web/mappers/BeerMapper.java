package praga.springframework.msscbeerservice.web.mappers;

import org.mapstruct.Mapper;
import praga.springframework.msscbeerservice.web.domain.Beer;
import praga.springframework.msscbeerservice.web.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDto beerDto);
    BeerDto beerToBeerDto(Beer beer);
}
