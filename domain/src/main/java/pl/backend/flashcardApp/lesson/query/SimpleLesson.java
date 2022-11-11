package pl.backend.flashcardApp.lesson.query;

public class SimpleLesson {

    public static SimpleLesson restore(final SimpleLessonSnapshot snapshot) {
        return new SimpleLesson(
                snapshot.getId(),
                snapshot.getName(),
                snapshot.getLevel(),
                snapshot.getMotherLanguage(),
                snapshot.getForeignLanguage()
        );
    }

    private final Long id;
    private final String name;
    private final String level;
    private final String motherLanguage;
    private final String foreignLanguage;

    private SimpleLesson(final Long id, final String name, final String level, final String motherLanguage, final String foreignLanguage) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.motherLanguage = motherLanguage;
        this.foreignLanguage = foreignLanguage;
    }

    public SimpleLessonSnapshot getSnapshot() {
        return new SimpleLessonSnapshot(id, name, level, motherLanguage, foreignLanguage);
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
