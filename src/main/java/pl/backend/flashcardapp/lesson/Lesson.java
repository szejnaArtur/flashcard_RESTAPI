package pl.backend.flashcardapp.lesson;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;


@NoArgsConstructor
@Entity
@Table(name = "lessons")
public class Lesson {

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

    public Lesson(final LessonDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.level = dto.getLevel();
    }

    LessonDto toDto() {
        return LessonDto.builder()
                .withId(id)
                .withName(name)
                .withLevel(level)
                .build();
    }

    public Long getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getLevel() {
        return level;
    }
}
