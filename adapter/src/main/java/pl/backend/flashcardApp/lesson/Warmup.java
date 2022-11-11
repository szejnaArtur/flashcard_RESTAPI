package pl.backend.flashcardApp.lesson;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component("lessonWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {

    private final SqlLessonRepositories lessonRepository;

    Warmup(final SqlLessonRepositories lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (lessonRepository.count() == 0) {
            List<Lesson> lessons = new ArrayList<>();
            lessons.add(Lesson.restore(new LessonSnapshot(null, "Human", "Intermediate", "english", "polish")));
            lessons.add(Lesson.restore(new LessonSnapshot(null, "Personality", "Intermediate", "english", "polish")));
            lessons.add(Lesson.restore(new LessonSnapshot(null, "Feelings", "Pre-Intermediate", null, null)));
            lessons.add(Lesson.restore(new LessonSnapshot(null, "Body language", null, null, null)));
            lessons.add(Lesson.restore(new LessonSnapshot(null, "The home", "Basic", null, null)));

            lessonRepository.saveAll(
                    lessons.stream().map(Lesson::getSnapshot).collect(toList())
            );
        }
    }
}
