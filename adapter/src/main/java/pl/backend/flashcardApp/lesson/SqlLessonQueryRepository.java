package pl.backend.flashcardApp.lesson;

import org.springframework.data.repository.Repository;

public interface SqlLessonQueryRepository extends LessonQueryRepository, Repository<LessonSnapshot, Long> {


}
