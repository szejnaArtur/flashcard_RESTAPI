package pl.backend.flashcardapp.lesson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.backend.flashcardapp.lesson.dto.LessonDto;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lessons")
class LessonController {

    private final LessonFacade lessonFacade;
    private final LessonQueryRepository lessonQueryRepository;

    LessonController(final LessonFacade lessonFacade, final LessonQueryRepository lessonQueryRepository) {
        this.lessonFacade = lessonFacade;
        this.lessonQueryRepository = lessonQueryRepository;
    }

    @GetMapping
    ResponseEntity<List<LessonDto>> findAll() {
        return ResponseEntity.ok().body(lessonQueryRepository.findAllBy());
    }

    @GetMapping("/{id}")
    ResponseEntity<LessonDto> findById(@PathVariable Long id) {
        return lessonQueryRepository.findDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<LessonDto> save(@RequestBody LessonDto lessonDto) {
        if (lessonDto.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        LessonDto result = lessonFacade.save(lessonDto);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }
}
