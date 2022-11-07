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
