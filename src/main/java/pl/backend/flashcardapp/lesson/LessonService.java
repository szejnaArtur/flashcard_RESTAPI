package pl.backend.flashcardapp.lesson;

import java.util.List;

interface LessonService {
    LessonDto findById(Long id);
    LessonDto findByName(String name);
    LessonDto findByLevel(String level);

    List<LessonDto> findAll();

    LessonDto save(LessonDto dto);
    LessonDto update(LessonDto dto);

    void deleteById(Long id);
    void deleteByName(String name);

}
