package pl.backend.flashcardapp.lesson;

import pl.backend.flashcardapp.lesson.dto.LessonDto;

public class LessonFacade {

    private final LessonRepository lessonRepository;
    private final LessonFactory lessonFactory;

    LessonFacade(final LessonRepository lessonRepository, final LessonFactory lessonFactory) {
        this.lessonRepository = lessonRepository;
        this.lessonFactory = lessonFactory;
    }

    LessonDto save(final LessonDto lessonDto) {
        Lesson toSave = lessonFactory.from(lessonDto);
        return toDto(lessonRepository.save(toSave));
    }

    private LessonDto toDto(Lesson lesson) {
        return LessonDto.builder()
                .withId(lesson.getId())
                .withName(lesson.getName())
                .withLevel(lesson.getLevel())
                .build();
    }
}
