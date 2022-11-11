package pl.backend.flashcardApp.word;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.flashcardApp.lesson.LessonQueryRepository;
import pl.backend.flashcardApp.lesson.query.SimpleLesson;
import pl.backend.flashcardApp.lesson.query.SimpleLessonSnapshot;
import pl.backend.flashcardApp.word.dto.WordDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
class WordController {

    private final WordFacade wordFacade;
    private final LessonQueryRepository lessonQueryRepository;
    private final SqlWordQueryRepository sqlWordQueryRepository;

    WordController(final WordFacade wordFacade, final LessonQueryRepository lessonQueryRepository, final SqlWordQueryRepository sqlWordQueryRepository) {
        this.wordFacade = wordFacade;
        this.lessonQueryRepository = lessonQueryRepository;
        this.sqlWordQueryRepository = sqlWordQueryRepository;
    }

    @GetMapping("/words")
    ResponseEntity<List<WordDto>> findAll() {
        return ResponseEntity.ok().body(new ArrayList<>(sqlWordQueryRepository.findBy(WordDto.class)));
    }

    @GetMapping("/words/{id}")
    ResponseEntity<WordDto> findById(@PathVariable Long id) {
        return sqlWordQueryRepository.findDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/words/lesson/{id}")
    ResponseEntity<List<WordDto>> findAllByLessonId(@PathVariable Long id) {
        return ResponseEntity.ok().body(sqlWordQueryRepository.findAllByLessonId(id));
    }

    @PostMapping("/lessons/{id}/word")
    WordDto createWord(@PathVariable Long id, @RequestBody WordDto dto) {
        Optional<SimpleLesson> optionalSimpleLesson = lessonQueryRepository.findDtoById(id)
                .map(lesson -> SimpleLesson.restore(new SimpleLessonSnapshot(
                        lesson.getId(),
                        lesson.getName(),
                        lesson.getLevel(),
                        lesson.getMotherLanguage(),
                        lesson.getMotherLanguage()))
                );

        return optionalSimpleLesson
                .map(simpleLessonQueryDto -> wordFacade.save(dto, simpleLessonQueryDto))
                .orElse(null);
    }
}
