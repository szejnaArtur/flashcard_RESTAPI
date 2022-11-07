package pl.backend.flashcardapp.word;

import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryDto;
import pl.backend.flashcardapp.word.dto.WordDto;

class WordFactory {

    Word from(final WordDto source, final SimpleLessonQueryDto lesson) {
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
