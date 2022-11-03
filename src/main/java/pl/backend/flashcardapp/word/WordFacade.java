package pl.backend.flashcardapp.word;

import org.springframework.stereotype.Service;
import pl.backend.flashcardapp.lesson.LessonFacade;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class WordFacade {

    private final WordRepository wordRepository;
    private final WordFactory wordFactory;

    WordFacade(final WordRepository wordRepository, final WordFactory wordFactory) {
        this.wordRepository = wordRepository;
        this.wordFactory = wordFactory;
    }

    List<WordDto> findAll() {
        return wordRepository.findAll().stream()
                .map(Word::toDto).collect(toList());
    }

    List<WordDto> findByLessonId(final Long id) {
        return wordRepository.findAllByLessonId(id).stream()
                .map(Word::toDto).collect(toList());
    }

    public WordDto save(final WordDto word, final SimpleLessonQueryDto lesson) {
        return wordRepository.save(
                wordFactory.from(word, lesson)
        ).toDto();
    }
}
