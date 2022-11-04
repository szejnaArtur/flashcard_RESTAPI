package pl.backend.flashcardapp.word;

import org.springframework.stereotype.Service;
import pl.backend.flashcardapp.lesson.query.SimpleLessonQueryDto;
import pl.backend.flashcardapp.word.dto.WordDto;

@Service
class WordFactory {

    Word from(final WordDto source, final SimpleLessonQueryDto lesson) {
        return new Word(source, lesson);
    }

}
