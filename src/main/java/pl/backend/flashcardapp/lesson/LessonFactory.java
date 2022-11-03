package pl.backend.flashcardapp.lesson;

import org.springframework.stereotype.Service;

@Service
class LessonFactory {

    Lesson from(final LessonDto dto) {
        return new Lesson(dto.getId(), dto.getName(), dto.getLevel());
    }

}
