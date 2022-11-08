package pl.backend.flashcardapp.lesson;

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
            lessons.add(new Lesson(null, "The mind", "Basic"));
            lessons.add(new Lesson(null, "Personality", "Intermediate"));
            lessons.add(new Lesson(null, "Feelings", "Pre-Intermediate"));
            lessons.add(new Lesson(null, "Body language", null));
            lessons.add(new Lesson(null, "The home", "Basic"));

            lessonRepository.saveAll(
                    lessons.stream().map(SqlLesson::fromWord).collect(toList())
            );
        }
    }
}
