package pl.backend.flashcardapp.word;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize
public class WordDto {

    public static Builder builder() {
        return new Builder();
    }

    private final Long id;
    private final String text;
    private final String language;
    private final String pairCode;

    private WordDto(final Builder builder) {
        this.id = builder.id;
        this.text = builder.text;
        this.language = builder.language;
        this.pairCode = builder.pairCode;
    }

    public Builder toBuilder() {
        return builder()
                .withId(id)
                .withText(text)
                .withLanguage(language)
                .withPairCode(pairCode);
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getLanguage() {
        return language;
    }

    public String getPairCode() {
        return pairCode;
    }

    @JsonPOJOBuilder
    public static class Builder {
        private Long id;
        private String text;
        private String language;
        private String pairCode;

        private Builder() {
        }

        public WordDto build() {
            return new WordDto(this);
        }

        public Builder withId(final Long id) {
            this.id = id;
            return this;
        }

        public Builder withText(final String text) {
            this.text = text;
            return this;
        }

        public Builder withLanguage(final String language) {
            this.language = language;
            return this;
        }

        public Builder withPairCode(final String pairCode) {
            this.pairCode = pairCode;
            return this;
        }
    }
}
