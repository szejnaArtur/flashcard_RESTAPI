package pl.backend.flashcardapp.lesson;

import pl.backend.flashcardapp.lesson.dto.LessonDto;

class LessonFactory {

    Lesson from(final LessonDto dto) {
        return new Lesson(dto.getId(), dto.getName(), dto.getLevel());
    }

}
