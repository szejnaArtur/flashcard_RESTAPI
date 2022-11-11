package pl.backend.flashcardApp.word.dto;

public class WordDto {

    public static Builder builder() {
        return new Builder();
    }

    private final Long id;

    private final String motherLanguageWord;

    private final String foreignLanguageWord;

    private final String partOfSpeech;

    public WordDto(final Long id, final String motherLanguageWord, final String foreignLanguageWord, final String partOfSpeech) {
        this.id = id;
        this.motherLanguageWord = motherLanguageWord;
        this.foreignLanguageWord = foreignLanguageWord;
        this.partOfSpeech = partOfSpeech;
    }

    public Builder toBuilder() {
        return builder()
                .withId(id)
                .withMotherLanguageWord(motherLanguageWord)
                .withForeignLanguageWord(foreignLanguageWord)
                .withPartOfSpeech(partOfSpeech);
    }

    public Long getId() {
        return id;
    }

    public String getMotherLanguageWord() {
        return motherLanguageWord;
    }

    public String getForeignLanguageWord() {
        return foreignLanguageWord;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public static class Builder {
        private Long id;

        private String motherLanguageWord;

        private String foreignLanguageWord;

        private String partOfSpeech;


        private Builder() {
        }

        public WordDto build() {
            return new WordDto(
                    id,
                    motherLanguageWord,
                    foreignLanguageWord,
                    partOfSpeech
            );
        }

        public Builder withId(final Long id) {
            this.id = id;
            return this;
        }

        public Builder withMotherLanguageWord(final String motherLanguageWord) {
            this.motherLanguageWord = motherLanguageWord;
            return this;
        }

        public Builder withForeignLanguageWord(final String foreignLanguageWord) {
            this.foreignLanguageWord = foreignLanguageWord;
            return this;
        }

        public Builder withPartOfSpeech(final String partOfSpeech) {
            this.partOfSpeech = partOfSpeech;
            return this;
        }
    }
}
