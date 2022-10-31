package pl.backend.flashcardapp.lesson;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;


@NoArgsConstructor
@Entity
class Lesson {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String level;


    Lesson(final Long id, final String name, final String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    Lesson(final LessonDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.level = dto.getLevel();
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
