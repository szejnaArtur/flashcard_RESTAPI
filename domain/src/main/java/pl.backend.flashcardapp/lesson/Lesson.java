package pl.backend.flashcardapp.lesson;

class Lesson {

    private Long id;
    private String name;
    private String level;

    Lesson(final Long id, final String name, final String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    String getLevel() {
        return level;
    }

    void setLevel(final String level) {
        this.level = level;
    }
}
