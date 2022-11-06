package pl.backend.flashcardapp.word;

import org.springframework.stereotype.Service;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryDto;
import pl.backend.flashcardapp.word.dto.WordDto;

@Service
public class WordFacade {

    private final WordRepository wordRepository;
    private final WordFactory wordFactory;

    WordFacade(final WordRepository wordRepository, final WordFactory wordFactory) {
        this.wordRepository = wordRepository;
        this.wordFactory = wordFactory;
    }

    public WordDto save(final WordDto word, final SimpleLessonQueryDto lesson) {
        return wordRepository.save(
                wordFactory.from(word, lesson)
        ).toDto();
    }
}
