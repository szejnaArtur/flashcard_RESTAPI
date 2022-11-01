package pl.backend.flashcardapp.word;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.backend.flashcardapp.lesson.Lesson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "words")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String language;

    private String pairCode;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    Word(WordDto dto, Lesson lesson) {
        this.id = dto.getId();
        this.text = dto.getText();
        this.language = dto.getLanguage();
        this.pairCode = dto.getPairCode();
        this.lesson = lesson;
    }
}
