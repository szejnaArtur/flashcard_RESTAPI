package pl.backend.flashcardapp.word;

import lombok.AllArgsConstructor;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryDto;
import pl.backend.flashcardapp.word.dto.WordDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "words")
@AllArgsConstructor //TODO Only for creating test data in the database
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

    public Word(){}

    Word(WordDto dto, SimpleLessonQueryDto lesson) {
        this.id = dto.getId();
        this.text = dto.getText();
        this.language = dto.getLanguage();
        this.pairCode = dto.getPairCode();
        this.partOfSpeech = dto.getPartOfSpeech();
        this.lesson = lesson;
    }

    WordDto toDto() {
        return WordDto.builder()
                .withId(id)
                .withText(text)
                .withLanguage(language)
                .withPairCode(pairCode)
                .withPartOfSpeech(partOfSpeech)
                .build();
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
