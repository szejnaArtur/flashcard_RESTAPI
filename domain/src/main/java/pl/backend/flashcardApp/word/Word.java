package pl.backend.flashcardApp.word;

import lombok.NoArgsConstructor;
import pl.backend.flashcardApp.lesson.query.SimpleLesson;

@NoArgsConstructor
class Word {

    static Word restore(WordSnapshot snapshot) {
        return new Word(snapshot.getId(),
                snapshot.getMotherLanguageWord(),
                snapshot.getForeignLanguageWord(),
                snapshot.getPartOfSpeech(),
                snapshot.getLesson() != null ? SimpleLesson.restore(snapshot.getLesson()) : null
        );
    }

    private Long id;

    private String motherLanguageWord;

    private String foreignLanguageWord;

    private String partOfSpeech;

    private SimpleLesson lesson;

    private Word(final Long id, final String motherLanguageWord, final String foreignLanguageWord, final String partOfSpeech, final SimpleLesson lesson) {
        this.id = id;
        this.motherLanguageWord = motherLanguageWord;
        this.foreignLanguageWord = foreignLanguageWord;
        this.partOfSpeech = partOfSpeech;
        this.lesson = lesson;
    }

    WordSnapshot getSnapshot(){
        return new WordSnapshot(
                id,
                motherLanguageWord,
                foreignLanguageWord,
                partOfSpeech,
                lesson != null ? lesson.getSnapshot() : null
        );
    }

    void updateInfo(String motherLanguageWord, String foreignLanguageWord, String partOfSpeech) {
        this.motherLanguageWord = motherLanguageWord;
        this.foreignLanguageWord = foreignLanguageWord;
        this.partOfSpeech = partOfSpeech;
    }
}
