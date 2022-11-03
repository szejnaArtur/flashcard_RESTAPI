package pl.backend.flashcardapp.lesson;

import org.springframework.stereotype.Service;
import pl.backend.flashcardapp.word.WordDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonFacade {

    private final LessonRepository lessonRepository;
    private final LessonFactory lessonFactory;

    LessonFacade(final LessonRepository lessonRepository, final LessonFactory lessonFactory) {
        this.lessonRepository = lessonRepository;
        this.lessonFactory = lessonFactory;
    }

    List<LessonDto> findAll() {
        return lessonRepository.findAll().stream()
                .map(Lesson::toDto).collect(Collectors.toList());
    }

    public LessonDto findById(final Long id) {
        Optional<Lesson> optionalLesson = lessonRepository.findById(id);
        return optionalLesson
                .map(Lesson::toDto)
                .orElse(null);
    }

    LessonDto save(final LessonDto lessonDto) {
        Lesson toSave = lessonFactory.from(lessonDto);
        return lessonRepository.save(toSave).toDto();
    }
}
