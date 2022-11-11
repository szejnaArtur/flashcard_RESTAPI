package pl.backend.flashcardApp.lesson;

import pl.backend.flashcardApp.lesson.dto.LessonDto;

import java.util.List;
import java.util.Optional;

public interface LessonQueryRepository {

    List<LessonDto> findAllBy();

    Optional<LessonDto> findDtoById(Long id);
}
