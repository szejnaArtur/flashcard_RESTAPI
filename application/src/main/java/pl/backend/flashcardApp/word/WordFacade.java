package pl.backend.flashcardApp.word;

import pl.backend.flashcardApp.lesson.query.SimpleLesson;
import pl.backend.flashcardApp.word.dto.WordDto;

import java.util.Optional;

public class WordFacade {

    private final WordRepository wordRepository;

    private final WordFactory wordFactory;

    WordFacade(final WordRepository wordRepository, final WordFactory wordFactory) {
        this.wordRepository = wordRepository;
        this.wordFactory = wordFactory;
    }

    public WordDto save(final WordDto word, final SimpleLesson lesson) {
        return toDto(wordRepository.save(
                wordFactory.from(word, lesson)
        ));
    }

    public WordDto update(final WordDto dto) {

        Optional<Word> optionalWord = wordRepository.findById(dto.getId());

        if (optionalWord.isPresent()){
            return toDto(optionalWord.map(existingWord -> {
                existingWord.updateInfo(
                        dto.getMotherLanguageWord(),
                        dto.getForeignLanguageWord(),
                        dto.getPartOfSpeech()
                );
                return existingWord;
            }).get());
        } else {
            return null;
        }
    }

    private WordDto toDto(Word word) {

        WordSnapshot snap = word.getSnapshot();
        return WordDto.builder()
                .withId(snap.getId())
                .withMotherLanguageWord(snap.getMotherLanguageWord())
                .withForeignLanguageWord(snap.getForeignLanguageWord())
                .withPartOfSpeech(snap.getPartOfSpeech())
                .build();
    }
}
