package pl.backend.flashcardapp.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

interface LessonRepository extends JpaRepository<Lesson, Long> {

    Optional<Lesson> findById(Long aLong);

    <S extends Lesson> S save(S entity);

    <S extends Lesson> List<S> saveAll(Iterable<S> entities);

    void deleteById(Long id);

}
