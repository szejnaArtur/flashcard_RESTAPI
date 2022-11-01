package pl.backend.flashcardapp.word;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordDto {

    private Long id;

    private String text;

    private String language;

    private String pairCode;

    private Long lessonId;


    WordDto(Word word) {
        this.id = word.getId();
        this.text = word.getText();
        this.language = word.getLanguage();
        this.pairCode = word.getPairCode();
        this.lessonId = word.getLesson().getId();
    }
}
