package pl.backend.flashcardApp.lesson;

class Lesson {

    static Lesson restore(LessonSnapshot snapshot) {
        return new Lesson(
                snapshot.getId(),
                snapshot.getName(),
                snapshot.getLevel(),
                snapshot.getMotherLanguage(),
                snapshot.getForeignLanguage()
        );
    }

    private Long id;
    private String name;
    private String level;
    private String motherLanguage;
    private String foreignLanguage;

    private Lesson(final Long id, final String name, final String level, final String motherLanguage, String foreignLanguage) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.motherLanguage = motherLanguage;
        this.foreignLanguage = foreignLanguage;
    }

    LessonSnapshot getSnapshot() {
        return new LessonSnapshot(
                id,
                name,
                level,
                motherLanguage,
                foreignLanguage
        );
    }
}
