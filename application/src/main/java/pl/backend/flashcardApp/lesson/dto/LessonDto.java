package pl.backend.flashcardApp.lesson.dto;

public class LessonDto {

    public static Builder builder() {
        return new Builder();
    }

    private final Long id;
    private final String name;
    private final String level;

    private final String motherLanguage;

    private final String foreignLanguage;

    public LessonDto(final Long id, final String name, final String level, final String motherLanguage, final String foreignLanguage) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.motherLanguage = motherLanguage;
        this.foreignLanguage = foreignLanguage;
    }

    public Builder toBuilder() {
        return builder()
                .withId(id)
                .withName(name)
                .withLevel(level)
                .withMotherLanguage(motherLanguage)
                .withForeignLanguage(foreignLanguage);
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

    public String getMotherLanguage() {
        return motherLanguage;
    }

    public String getForeignLanguage() {
        return foreignLanguage;
    }

    public static class Builder {

        private Long id;
        private String name;
        private String level;

        private String motherLanguage;

        private String foreignLanguage;

        private Builder() {
        }

        public LessonDto build() {
            return new LessonDto(
                    id,
                    name,
                    level,
                    motherLanguage,
                    foreignLanguage
            );
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

        public Builder withMotherLanguage(final String motherLanguage) {
            this.motherLanguage = motherLanguage;
            return this;
        }

        public Builder withForeignLanguage(final String foreignLanguage) {
            this.foreignLanguage = foreignLanguage;
            return this;
        }
    }
}
