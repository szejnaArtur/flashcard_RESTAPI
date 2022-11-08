package pl.backend.flashcardapp.word;

import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryEntity;
import pl.backend.flashcardapp.word.dto.WordDto;

public class WordFacade {

    private final WordRepository wordRepository;
    private final WordFactory wordFactory;

    WordFacade(final WordRepository wordRepository, final WordFactory wordFactory) {
        this.wordRepository = wordRepository;
        this.wordFactory = wordFactory;
    }

    public WordDto save(final WordDto word, final SimpleLessonQueryEntity lesson) {
        return toDto(wordRepository.save(
                wordFactory.from(word, lesson)
        ));
    }

    private WordDto toDto(Word word) {
        return WordDto.builder()
                .withId(word.getId())
                .withText(word.getText())
                .withLanguage(word.getLanguage())
                .withPairCode(word.getPairCode())
                .withPartOfSpeech(word.getPartOfSpeech())
                .build();
    }
}
