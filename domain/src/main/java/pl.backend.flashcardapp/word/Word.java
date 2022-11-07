package pl.backend.flashcardapp.word;

import lombok.NoArgsConstructor;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "words")
@NoArgsConstructor
class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String language;

    private String pairCode;

    private String partOfSpeech;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private SimpleLessonQueryDto lesson;

    Word(final Long id, final String text, final String language, final String pairCode, final String partOfSpeech, final SimpleLessonQueryDto lesson) {
        this.id = id;
        this.text = text;
        this.language = language;
        this.pairCode = pairCode;
        this.partOfSpeech = partOfSpeech;
        this.lesson = lesson;
    }

    Long getId() {
        return id;
    }

    String getText() {
        return text;
    }

    String getLanguage() {
        return language;
    }

    String getPairCode() {
        return pairCode;
    }

    String getPartOfSpeech() {
        return partOfSpeech;
    }

    SimpleLessonQueryDto getLesson() {
        return lesson;
    }
}
