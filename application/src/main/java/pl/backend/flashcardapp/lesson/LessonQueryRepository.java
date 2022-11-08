package pl.backend.flashcardapp.lesson;

import pl.backend.flashcardapp.lesson.dto.LessonDto;

import java.util.List;
import java.util.Optional;

public interface LessonQueryRepository {

    List<LessonDto> findAllBy();

    Optional<LessonDto> findDtoById(Long id);
}
