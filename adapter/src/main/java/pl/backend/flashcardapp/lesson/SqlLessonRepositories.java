package pl.backend.flashcardapp.lesson;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface SqlLessonRepositories extends Repository<SqlLesson, Long> {
    int count();

    Optional<SqlLesson> findById(Long id);

    SqlLesson save(SqlLesson entity);

    List<SqlLesson> saveAll(Iterable<SqlLesson> entities);

    void deleteById(Long id);
}

