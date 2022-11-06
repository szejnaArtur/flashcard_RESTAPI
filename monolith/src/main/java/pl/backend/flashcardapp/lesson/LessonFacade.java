package pl.backend.flashcardapp.lesson;

import org.springframework.stereotype.Service;
import pl.backend.flashcardapp.lesson.dto.LessonDto;

@Service
public class LessonFacade {

    private final LessonRepository lessonRepository;
    private final LessonFactory lessonFactory;

    LessonFacade(final LessonRepository lessonRepository, final LessonFactory lessonFactory) {
        this.lessonRepository = lessonRepository;
        this.lessonFactory = lessonFactory;
    }

    LessonDto save(final LessonDto lessonDto) {
        Lesson toSave = lessonFactory.from(lessonDto);
        return lessonRepository.save(toSave).toDto();
    }
}
