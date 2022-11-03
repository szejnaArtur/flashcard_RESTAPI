package pl.backend.flashcardapp.word;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.flashcardapp.lesson.LessonDto;
import pl.backend.flashcardapp.lesson.LessonFacade;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryDto;

import java.util.List;

@RestController
@RequestMapping
class WordController {

    private final WordFacade wordFacade;
    private final LessonFacade lessonFacade;

    WordController(final WordFacade wordFacade, final LessonFacade lessonFacade) {
        this.wordFacade = wordFacade;
        this.lessonFacade = lessonFacade;
    }

    @GetMapping("/words")
    ResponseEntity<List<WordDto>> findAll() {
        return ResponseEntity.ok().body(wordFacade.findAll());
    }

    @GetMapping("/words/lesson/{id}")
    ResponseEntity<List<WordDto>> findAllByLessonId(@PathVariable Long id) {
        return ResponseEntity.ok().body(wordFacade.findByLessonId(id));
    }

    @PostMapping("/lessons/{id}/word")
    WordDto createWord(@PathVariable Long id, @RequestBody WordDto dto){
        LessonDto lessonDto = lessonFacade.findById(id);

        return wordFacade.save(dto, new SimpleLessonQueryDto(
                lessonDto.getId(),
                lessonDto.getName(),
                lessonDto.getLevel()
        ));
    }
}
