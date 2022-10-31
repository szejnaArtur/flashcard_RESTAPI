package pl.backend.flashcardapp.lesson;

import java.util.List;

interface LessonService {

    List<LessonDto> findAll();
//    List<LessonDto> findAllByLevel(String level);

    LessonDto findById(Long id);
//    LessonDto findByName(String name);

    Lesson save(LessonDto lessonDto);
//    LessonDto update(LessonDto lessonDto);

}
