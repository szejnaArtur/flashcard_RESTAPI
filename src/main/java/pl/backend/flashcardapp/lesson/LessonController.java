package pl.backend.flashcardapp.lesson;

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
@RequestMapping("/lessons")
class LessonController {

    private final LessonService lessonService;

    LessonController(final LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    List<LessonDto> findAll() {
        return lessonService.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<LessonDto> findById(@PathVariable Long id){
        LessonDto dto = lessonService.findById(id);
        if (dto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    ResponseEntity<LessonDto> save(@RequestBody LessonDto lessonDto){
        if (lessonDto.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Lesson result = lessonService.save(lessonDto);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(new LessonDto(result));
    }

}
