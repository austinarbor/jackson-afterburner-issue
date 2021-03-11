package dev.aga.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
@JsonDeserialize(builder = Context.ContextBuilder.class)
public class Context {
    private final String name;
    private final Integer id;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ContextBuilder {

    }
}
