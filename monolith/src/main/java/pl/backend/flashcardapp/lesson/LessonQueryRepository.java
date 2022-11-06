package pl.backend.flashcardapp.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.backend.flashcardapp.lesson.dto.LessonDto;

import java.util.List;
import java.util.Optional;

public interface LessonQueryRepository extends JpaRepository<Lesson, Long> {

    List<LessonDto> findAllBy();

    Optional<LessonDto> findDtoById(Long id);
}
