package messiasproject.microservicespecialist.order.config.util.modelmapper;

import messiasproject.microservicespecialist.order.domain.exception.ListEmptyException;
import messiasproject.microservicespecialist.order.domain.exception.RecordDoesntExist;
import org.modelmapper.ModelMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static messiasproject.microservicespecialist.order.config.bean.modelmapper.ModelMapperConfig.modelMapper;

public class ModelMapperConvert {
    public static <T> T convert(Object objectWithContent, Class<T> classCopy) {
        if (ObjectUtils.isEmpty(objectWithContent)) {
            throw new RecordDoesntExist(new Object[]{"objeto com conteúdo dentro da conversão do modelMap"});
        }else {
            ModelMapper modelMapper = modelMapper();
            return modelMapper.map(objectWithContent, classCopy);
        }
    }

    public static <T> T convert(Object objectWithContent, T objectNecessary) {
        if (ObjectUtils.isEmpty(objectWithContent)) {
            throw new RecordDoesntExist(new Object[]{"objeto com conteúdo dentro da conversão do modelMap"});
        } else {
            ModelMapper modelMapper = modelMapper();
            modelMapper.map(objectWithContent, objectNecessary);
            return objectNecessary;
        }
    }

    public static <T> List<T> convertList(Collection<?> listWithContent, Class<T> classCopy) {
        if (CollectionUtils.isEmpty(listWithContent)) {
            throw new ListEmptyException();
        } else {
            ModelMapper modelMapper = modelMapper();
            return listWithContent.stream()
                    .map(c -> modelMapper.map(c, classCopy))
                    .collect(Collectors.toList());
        }
    }
}
