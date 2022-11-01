package pl.backend.flashcardapp.lesson;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LessonFacade {

    private final LessonRepository lessonRepository;

    LessonFacade(final LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    List<LessonDto> findAll() {
        return lessonRepository.findAll().stream()
                .map(lesson -> LessonDto.builder()
                        .withId(lesson.getId())
                        .withName(lesson.getName())
                        .withLevel(lesson.getLevel())
                        .build()
                ).collect(Collectors.toList());
    }

    public LessonDto findById(final Long id) {
        Optional<Lesson> optionalLesson = lessonRepository.findById(id);
        return optionalLesson
                .map(lesson -> LessonDto.builder()
                        .withId(lesson.getId())
                        .withName(lesson.getName())
                        .withLevel(lesson.getLevel())
                        .build()
                ).orElse(null);
    }

    Lesson save(final LessonDto lessonDto) {
        Lesson toSave = new Lesson(lessonDto);
        return lessonRepository.save(toSave);
    }
}
