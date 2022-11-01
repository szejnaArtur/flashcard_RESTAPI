package pl.backend.flashcardapp.lesson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize
public class LessonDto {

    public static Builder builder() {
        return new Builder();
    }

    private final Long id;
    private final String name;
    private final String level;

    private LessonDto(final Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.level = builder.level;
    }

    public Builder toBuilder(){
        return builder()
                .withId(id)
                .withName(name)
                .withLevel(level);
    }



    public boolean isEmpty() {
        return name == null || name.equals("");
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    @JsonPOJOBuilder
    public static class Builder {

        private Long id;
        private String name;
        private String level;

        private Builder() {
        }

        public LessonDto build() {
            return new LessonDto(this);
        }

        public Builder withId(final Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withLevel(final String level) {
            this.level = level;
            return this;
        }
    }
}
