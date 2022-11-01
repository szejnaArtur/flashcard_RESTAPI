package pl.backend.flashcardapp.word;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/words")
class WordController {

    private final WordFacade wordFacade;

    WordController(final WordFacade wordFacade) {
        this.wordFacade = wordFacade;
    }

    @GetMapping
    ResponseEntity<List<WordDto>> findAll() {
        return ResponseEntity.ok().body(wordFacade.findAll());
    }

    @GetMapping("/lesson/{id}")
    ResponseEntity<List<WordDto>> findAllByLessonId(@PathVariable Long id) {
        return ResponseEntity.ok().body(wordFacade.findByLessonId(id));
    }

    @PostMapping
    ResponseEntity<WordDto> save(@RequestBody WordDto dto) {
//        if (dto.isEmpty()) {
//            return ResponseEntity.badRequest().build();
//        }
        Word result = wordFacade.save(dto);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(new WordDto(result));
    }
}
