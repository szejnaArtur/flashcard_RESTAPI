package pl.backend.flashcardapp.lesson;

import org.springframework.data.repository.Repository;

public interface SqlLessonQueryRepository extends LessonQueryRepository, Repository<SqlLesson, Long> {


}
