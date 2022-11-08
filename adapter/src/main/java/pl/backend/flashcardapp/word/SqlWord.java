package pl.backend.flashcardapp.word;

import org.springframework.data.annotation.PersistenceConstructor;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "words")
class SqlWord {

    static SqlWord fromWord(Word source) {
        var result = new SqlWord();
        result.id = source.getId();
        result.text = source.getText();
        result.language = source.getLanguage();
        result.pairCode = source.getPairCode();
        result.partOfSpeech = source.getPartOfSpeech();
        result.lesson = source.getLesson() == null ? null : new SimpleLessonQueryEntity(source.getLesson().getId(), source.getLesson().getName(),source.getLesson().getLevel());
        return result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String language;

    private String pairCode;

    private String partOfSpeech;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private SimpleLessonQueryEntity lesson;

    @PersistenceConstructor
    protected SqlWord(){}

    Word toWord(){
        return new Word(id, text, language, pairCode, partOfSpeech, lesson != null ? new SimpleLessonQueryEntity(lesson.getId(), lesson.getName(), lesson.getLevel()) : null);
    }
}
