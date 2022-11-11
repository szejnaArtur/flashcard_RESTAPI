package pl.backend.flashcardApp.lesson.query;

public class SimpleLessonSnapshot {

    private final Long id;
    private final String name;
    private final String level;
    private final String motherLanguage;
    private final String foreignLanguage;

    public SimpleLessonSnapshot(final Long id, final String name, final String level, final String motherLanguage, final String foreignLanguage) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.motherLanguage = motherLanguage;
        this.foreignLanguage = foreignLanguage;
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

    String getMotherLanguage() {
        return motherLanguage;
    }

    String getForeignLanguage() {
        return foreignLanguage;
    }
}
