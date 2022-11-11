package pl.backend.flashcardApp.lesson;

import pl.backend.flashcardApp.lesson.dto.LessonDto;

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
        LessonSnapshot snap = lesson.getSnapshot();
        return LessonDto.builder()
                .withId(snap.getId())
                .withName(snap.getName())
                .withLevel(snap.getLevel())
                .withMotherLanguage(snap.getMotherLanguage())
                .withForeignLanguage(snap.getForeignLanguage())
                .build();
    }
}
