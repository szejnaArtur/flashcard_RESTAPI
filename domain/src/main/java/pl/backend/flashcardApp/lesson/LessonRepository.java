package pl.backend.flashcardApp.lesson;

import java.util.List;
import java.util.Optional;

interface LessonRepository {

    int count();

    Optional<Lesson> findById(Long id);

    Lesson save(Lesson entity);

    List<Lesson> saveAll(Iterable<Lesson> entities);

    void deleteById(Long id);

}
