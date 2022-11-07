package pl.backend.flashcardapp.lesson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LessonConfiguration {

    @Bean
    LessonFacade lessonFacade(final LessonRepository lessonRepository){
        return new LessonFacade(lessonRepository, new LessonFactory());
    }

}
