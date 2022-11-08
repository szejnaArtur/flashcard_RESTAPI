package pl.backend.flashcardapp.word;

import lombok.NoArgsConstructor;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryEntity;

@NoArgsConstructor
class Word {

    private Long id;

    private String text;

    private String language;

    private String pairCode;

    private String partOfSpeech;

    private SimpleLessonQueryEntity lesson;

    Word(final Long id, final String text, final String language, final String pairCode, final String partOfSpeech, final SimpleLessonQueryEntity lesson) {
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

    SimpleLessonQueryEntity getLesson() {
        return lesson;
    }
}
