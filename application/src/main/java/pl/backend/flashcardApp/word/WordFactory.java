package pl.backend.flashcardApp.word;

import pl.backend.flashcardApp.lesson.query.SimpleLesson;
import pl.backend.flashcardApp.word.dto.WordDto;

class WordFactory {

    Word from(final WordDto source, final SimpleLesson lesson) {
        return Word.restore(
                new WordSnapshot(
                        source.getId(),
                        source.getMotherLanguageWord(),
                        source.getForeignLanguageWord(),
                        source.getPartOfSpeech(),
                        lesson.getSnapshot()
                )
        );
    }

}
