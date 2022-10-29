package pl.backend.flashcardapp.lesson;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Override
    Optional<Lesson> findById(Long aLong);

    Optional<Lesson> findByName(String name);

    Optional<Lesson> findByLevel(String level);
}
