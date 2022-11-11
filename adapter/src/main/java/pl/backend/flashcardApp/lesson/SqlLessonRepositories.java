package pl.backend.flashcardApp.lesson;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface SqlLessonRepositories extends Repository<LessonSnapshot, Long> {
    int count();

    Optional<LessonSnapshot> findById(Long id);

    LessonSnapshot save(LessonSnapshot entity);

    List<LessonSnapshot> saveAll(Iterable<LessonSnapshot> entities);

    void deleteById(Long id);
}

