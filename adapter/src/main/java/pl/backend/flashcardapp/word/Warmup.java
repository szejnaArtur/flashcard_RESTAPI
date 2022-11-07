package pl.backend.flashcardapp.word;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.backend.flashcardapp.lesson.LessonQueryRepository;
import pl.backend.flashcardapp.lesson.dto.LessonDto;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("wordWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {

    private final WordRepository wordRepository;
    private final LessonQueryRepository lessonQueryRepository;

    Warmup(final WordRepository wordRepository, final LessonQueryRepository lessonQueryRepository) {
        this.wordRepository = wordRepository;
        this.lessonQueryRepository = lessonQueryRepository;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        Optional<LessonDto> optionalLessonDto = lessonQueryRepository.findDtoById(2L);
        SimpleLessonQueryDto lesson = null;
        if (optionalLessonDto.isPresent()) {
            LessonDto dto = optionalLessonDto.get();
            lesson = new SimpleLessonQueryDto(dto.getId(), dto.getName(), dto.getLevel());
        }

        if (wordRepository.count() == 0) {
            List<Word> words = new ArrayList<>();
            words.add(new Word(null, "gulliable", "english", "as86ei23", "adjective", lesson));
            words.add(new Word(null, "łatwowierny", "polish", "as86ei23", "adjective", lesson));
            words.add(new Word(null, "mean", "english", "fu4s9r3c", "adjective", lesson));
            words.add(new Word(null, "skąpy", "polish", "fu4s9r3c", "adjective", lesson));
            words.add(new Word(null, "bright", "english", "z9e4f2a6", "adjective", lesson));
            words.add(new Word(null, "bystry", "polish", "z9e4f2a6", "adjective", lesson));
            words.add(new Word(null, "leichtgläubig", "german", "as86ei23", "adjective", lesson));
            words.add(new Word(null, "billig", "german", "fu4s9r3c", "adjective", lesson));

            wordRepository.saveAll(words);
        }
    }
}
