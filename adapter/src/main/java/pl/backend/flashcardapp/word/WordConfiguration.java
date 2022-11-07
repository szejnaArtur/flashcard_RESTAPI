package pl.backend.flashcardapp.word;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WordConfiguration {

    @Bean
    WordFacade wordFacade(final WordRepository wordRepository) {
        return new WordFacade(wordRepository, new WordFactory());
    }

}
