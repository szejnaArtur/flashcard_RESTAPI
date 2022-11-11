package pl.backend.flashcardApp.lesson;

import pl.backend.flashcardApp.lesson.dto.LessonDto;

class LessonFactory {

    Lesson from(final LessonDto dto) {
        return Lesson.restore(new LessonSnapshot(dto.getId(), dto.getName(), dto.getLevel(), dto.getMotherLanguage(), dto.getForeignLanguage()));
    }

}
