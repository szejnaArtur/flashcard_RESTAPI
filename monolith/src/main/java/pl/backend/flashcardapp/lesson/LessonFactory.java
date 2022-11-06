package pl.backend.flashcardapp.lesson;

import org.springframework.stereotype.Service;
import pl.backend.flashcardapp.lesson.dto.LessonDto;

@Service
class LessonFactory {

    Lesson from(final LessonDto dto) {
        return new Lesson(dto.getId(), dto.getName(), dto.getLevel());
    }

}
