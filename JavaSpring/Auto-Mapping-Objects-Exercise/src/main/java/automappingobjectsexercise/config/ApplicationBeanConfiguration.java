package automappingobjectsexercise.config;

import automappingobjectsexercise.models.dto.GameAddDto;
import automappingobjectsexercise.models.entity.Game;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        };
        modelMapper.addConverter(localDateConverter);
        modelMapper.typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper ->{
                    mapper.map(GameAddDto::getThumbnailURL,
                            Game::setThumbnail);
                    mapper.using(localDateConverter).map(GameAddDto::getReleaseDate, Game::setReleaseDate);
                });

        return modelMapper;
    }
}