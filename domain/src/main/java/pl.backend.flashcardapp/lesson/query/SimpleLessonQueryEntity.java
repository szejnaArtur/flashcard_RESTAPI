package pl.backend.flashcardapp.lesson.query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "lessons")
public class SimpleLessonQueryEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String level;

    protected SimpleLessonQueryEntity() {}

    public SimpleLessonQueryEntity(final Long id, final String name, final String level) {
        this.id = id;
        this.name = name;
        this.level = level;
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
}