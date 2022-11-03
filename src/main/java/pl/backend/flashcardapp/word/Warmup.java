package pl.backend.flashcardapp.word;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.backend.flashcardapp.lesson.LessonDto;
import pl.backend.flashcardapp.lesson.LessonFacade;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryDto;

import java.util.ArrayList;
import java.util.List;

@Component("wordWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {

    private final WordRepository wordRepository;
    private final LessonFacade lessonFacade;

    Warmup(final WordRepository wordRepository, final LessonFacade lessonFacade) {
        this.wordRepository = wordRepository;
        this.lessonFacade = lessonFacade;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        LessonDto result = lessonFacade.findById(2L);
        SimpleLessonQueryDto lesson = new SimpleLessonQueryDto(result.getId(), result.getName(), result.getLevel());

        if (wordRepository.count() == 0) {
            List<Word> words = new ArrayList<>();
            words.add(new Word(null, "gulliable", "english", "as86ei23", lesson));
            words.add(new Word(null, "łatwowierny", "polish", "as86ei23", lesson));
            words.add(new Word(null, "mean", "english", "fu4s9r3c", lesson));
            words.add(new Word(null, "skąpy", "polish", "fu4s9r3c", lesson));
            words.add(new Word(null, "bright", "english", "z9e4f2a6", lesson));
            words.add(new Word(null, "bystry", "polish", "z9e4f2a6", lesson));
            words.add(new Word(null, "leichtgläubig", "german", "as86ei23", lesson));
            words.add(new Word(null, "billig", "german", "fu4s9r3c", lesson));

            wordRepository.saveAll(words);
        }
    }
}
