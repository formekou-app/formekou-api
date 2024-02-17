package neocode.formekouapi.endpoint.rest.mapper;

import lombok.AllArgsConstructor;
import neocode.formekouapi.endpoint.rest.model.Option;
import org.springframework.stereotype.Component;
@Component
@AllArgsConstructor
public class OptionMapper {
    public Option toRest(neocode.formekouapi.model.Option option){
        return Option.builder()
                .points(option.getPoints())
                .isCorrect(option.isCorrect())
                .value(option.getValue())
                .id(option.getId())
                .build();
    }

    public neocode.formekouapi.model.Option toDomain(Option option){
        return neocode.formekouapi.model.Option.builder()
                .points(option.getPoints())
                .isCorrect(option.isCorrect())
                .value(option.getValue())
                .id(option.getId())
                .build();
    }
}
