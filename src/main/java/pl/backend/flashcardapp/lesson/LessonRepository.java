package pl.backend.flashcardapp.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LessonRepository extends JpaRepository<Lesson, Long> {
}
