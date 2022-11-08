package pl.backend.flashcardapp.word;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.flashcardapp.lesson.LessonQueryRepository;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryEntity;
import pl.backend.flashcardapp.word.dto.WordDto;
import pl.backend.flashcardapp.word.dto.WordWithoutPartOfSpeechDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
class WordController {

    private final WordFacade wordFacade;
    private final LessonQueryRepository lessonQueryRepository;
    private final WordQueryRepository wordQueryRepository;

    WordController(final WordFacade wordFacade, final LessonQueryRepository lessonQueryRepository, final WordQueryRepository wordQueryRepository) {
        this.wordFacade = wordFacade;
        this.lessonQueryRepository = lessonQueryRepository;
        this.wordQueryRepository = wordQueryRepository;
    }

    @GetMapping("/words")
    ResponseEntity<List<WordDto>> findAll() {
        return ResponseEntity.ok().body(new ArrayList<>(wordQueryRepository.findBy(WordDto.class)));
    }

    @GetMapping("/words/{id}")
    ResponseEntity<WordDto> findById(@PathVariable Long id) {
        return wordQueryRepository.findDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/words/lesson/{id}")
    ResponseEntity<List<WordDto>> findAllByLessonId(@PathVariable Long id) {
        return ResponseEntity.ok().body(wordQueryRepository.findAllByLessonId(id));
    }

    @PostMapping("/lessons/{id}/word")
    WordDto createWord(@PathVariable Long id, @RequestBody WordDto dto) {
        Optional<SimpleLessonQueryEntity> optionalSimpleLessonQueryDto = lessonQueryRepository.findDtoById(id)
                .map(lesson -> new SimpleLessonQueryEntity(
                        lesson.getId(),
                        lesson.getName(),
                        lesson.getLevel())
                );

        return optionalSimpleLessonQueryDto
                .map(simpleLessonQueryDto -> wordFacade.save(dto, simpleLessonQueryDto))
                .orElse(null);
    }

    @GetMapping("/words/min_info")
    List<WordWithoutPartOfSpeechDto> listWithChanges() {
        return new ArrayList<>(wordQueryRepository.findBy(WordWithoutPartOfSpeechDto.class));
    }
}
