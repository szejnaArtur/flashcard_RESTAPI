package pl.backend.flashcardapp.lesson;

import lombok.NoArgsConstructor;

@NoArgsConstructor
class LessonDto {

    private Long id;
    private String name;
    private String level;

    LessonDto(final Long id, final String name, final String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    LessonDto(final Lesson lesson) {
        this.id = lesson.getId();
        this.name = lesson.getName();
        this.level = lesson.getLevel();
    }

    boolean isEmpty(){
        return name == null || name.equals("");
    }

    public Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    void setLevel(final String level) {
        this.level = level;
    }
}
