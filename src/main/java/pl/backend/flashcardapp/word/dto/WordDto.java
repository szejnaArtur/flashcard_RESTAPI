package pl.backend.flashcardapp.word.dto;

public
class WordDto {

    public static Builder builder() {
        return new Builder();
    }

    private final Long id;
    private final String text;
    private final String language;
    private final String pairCode;
    private final String partOfSpeech;

    public WordDto(final Long id, final String text, final String language, final String pairCode, final String partOfSpeech) {
        this.id = id;
        this.text = text;
        this.language = language;
        this.pairCode = pairCode;
        this.partOfSpeech = partOfSpeech;
    }

    public Builder toBuilder() {
        return builder()
                .withId(id)
                .withText(text)
                .withLanguage(language)
                .withPairCode(pairCode)
                .withPartOfSpeech(partOfSpeech);
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

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public static class Builder {
        private Long id;
        private String text;
        private String language;
        private String pairCode;
        private String partOfSpeech;


        private Builder() {
        }

        public WordDto build() {
            return new WordDto(
                    id,
                    text,
                    language,
                    pairCode,
                    partOfSpeech
            );
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

        public Builder withPartOfSpeech(final String partOfSpeech) {
            this.partOfSpeech = partOfSpeech;
            return this;
        }
    }
}
