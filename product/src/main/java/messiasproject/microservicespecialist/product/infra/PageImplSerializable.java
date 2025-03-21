package messiasproject.microservicespecialist.product.infra;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true, value = {"pageable"})
public class PageImplSerializable<T> extends PageImpl<T> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PageImplSerializable(
            @JsonProperty("content")List<T> content,
            @JsonProperty("page") int page,
            @JsonProperty("size") int size,
            @JsonProperty("totalElements") long total) {
        super(content, PageRequest.of(page, size), total);
    }
}
