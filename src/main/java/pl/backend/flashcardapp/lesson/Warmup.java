package pl.backend.flashcardapp.lesson;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("lessonWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {

    private final LessonRepository lessonRepository;

    Warmup(final LessonRepository lessonRepository) {
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

            lessonRepository.saveAll(lessons);
        }
    }
}
