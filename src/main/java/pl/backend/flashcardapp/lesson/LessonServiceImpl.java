package pl.backend.flashcardapp.lesson;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class LessonServiceImpl implements LessonService{

    private final LessonRepository lessonRepository;

    LessonServiceImpl(final LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<LessonDto> findAll() {
        return lessonRepository.findAll().stream()
                .map(LessonDto::new).collect(Collectors.toList());
    }

    @Override
    public LessonDto findById(final Long id) {
        Optional<Lesson> optionalLesson = lessonRepository.findById(id);
        return optionalLesson.map(LessonDto::new).orElse(null);
    }

    @Override
    public Lesson save(final LessonDto lessonDto) {
        Lesson toSave = new Lesson(lessonDto);
        return lessonRepository.save(toSave);
    }
}
