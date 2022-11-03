package pl.backend.flashcardapp.word;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
@Getter
@AllArgsConstructor
@NoArgsConstructor
class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String language;

    private String pairCode;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private SimpleLessonQueryDto lesson;

    Word(WordDto dto, SimpleLessonQueryDto lesson) {
        this.id = dto.getId();
        this.text = dto.getText();
        this.language = dto.getLanguage();
        this.pairCode = dto.getPairCode();
        this.lesson = lesson;
    }

    WordDto toDto() {
        return WordDto.builder()
                .withId(id)
                .withText(text)
                .withLanguage(language)
                .withPairCode(pairCode)
                .build();
    }
}
