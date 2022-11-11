package pl.backend.flashcardApp.lesson;

class LessonSnapshot {

    private Long id;
    private String name;
    private String level;
    private String motherLanguage;
    private String foreignLanguage;

    protected LessonSnapshot(){}

    LessonSnapshot(final Long id, final String name, final String level, final String motherLanguage, final String foreignLanguage) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.motherLanguage = motherLanguage;
        this.foreignLanguage = foreignLanguage;
    }

    Long getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getLevel() {
        return level;
    }

    String getMotherLanguage() {
        return motherLanguage;
    }

    String getForeignLanguage() {
        return foreignLanguage;
    }
}
