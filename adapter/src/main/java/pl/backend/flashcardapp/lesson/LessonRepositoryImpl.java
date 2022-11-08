package pl.backend.flashcardapp.lesson;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
class LessonRepositoryImpl implements LessonRepository {

    private final SqlLessonRepositories repository;

    LessonRepositoryImpl(final SqlLessonRepositories repository) {
        this.repository = repository;
    }

    @Override
    public int count() {
        return repository.count();
    }

    @Override
    public Optional<Lesson> findById(final Long id) {
        return repository.findById(id).map(SqlLesson::toWord);
    }

    @Override
    public Lesson save(final Lesson entity) {
        return repository.save(SqlLesson.fromWord(entity)).toWord();
    }

    @Override
    public List<Lesson> saveAll(final Iterable<Lesson> entities) {
        return repository.saveAll(
                        StreamSupport.stream(entities.spliterator(), false)
                                .map(SqlLesson::fromWord)
                                .collect(toList())
                ).stream()
                .map(SqlLesson::toWord)
                .collect(toList());
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}
