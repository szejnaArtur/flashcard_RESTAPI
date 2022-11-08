package pl.backend.flashcardapp.word;

import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryEntity;
import pl.backend.flashcardapp.word.dto.WordDto;

class WordFactory {

    Word from(final WordDto source, final SimpleLessonQueryEntity lesson) {
        return new Word(
                source.getId(),
                source.getText(),
                source.getLanguage(),
                source.getPairCode(),
                source.getPartOfSpeech(),
                lesson
        );
    }

}
