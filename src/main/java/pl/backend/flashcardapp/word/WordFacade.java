package pl.backend.flashcardapp.word;

import org.springframework.stereotype.Service;
import pl.backend.flashcardapp.lesson.Lesson;
import pl.backend.flashcardapp.lesson.LessonFacade;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class WordFacade {

    private final WordRepository wordRepository;
    private final LessonFacade lessonService;

    WordFacade(final WordRepository wordRepository, final LessonFacade lessonService) {
        this.wordRepository = wordRepository;
        this.lessonService = lessonService;
    }

    List<WordDto> findAll() {
        return wordRepository.findAll().stream()
                .map(WordDto::new).collect(toList());
    }

    List<WordDto> findByLessonId(final Long id) {
        return wordRepository.findAllByLessonId(id).stream()
                .map(WordDto::new).collect(toList());
    }

    Word save(final WordDto dto) {
        Lesson lesson = new Lesson(lessonService.findById(dto.getLessonId()));
        return wordRepository.save(new Word(dto, lesson));
    }
}
