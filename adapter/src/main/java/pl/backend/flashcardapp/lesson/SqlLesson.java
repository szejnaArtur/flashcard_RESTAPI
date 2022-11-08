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
class SqlLesson {

    static SqlLesson fromWord(Lesson source) {
        var result = new SqlLesson();
        result.id = source.getId();
        result.name = source.getName();
        result.level = source.getLevel();
        return result;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String level;

    SqlLesson(final Long id, final String name, final String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    Lesson toWord() {
        return new Lesson(id, name, level);
    }
}
