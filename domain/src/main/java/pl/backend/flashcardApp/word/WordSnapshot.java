package pl.backend.flashcardApp.word;

import pl.backend.flashcardApp.lesson.query.SimpleLessonSnapshot;

class WordSnapshot {

    private Long id;
    private String motherLanguageWord;
    private String foreignLanguageWord;
    private String partOfSpeech;
    private SimpleLessonSnapshot lesson;

    protected WordSnapshot(){}

    WordSnapshot(final Long id, final String motherLanguageWord, final String foreignLanguageWord, final String partOfSpeech, final SimpleLessonSnapshot lesson) {
        this.id = id;
        this.motherLanguageWord = motherLanguageWord;
        this.foreignLanguageWord = foreignLanguageWord;
        this.partOfSpeech = partOfSpeech;
        this.lesson = lesson;
    }

    Long getId() {
        return id;
    }

    String getMotherLanguageWord() {
        return motherLanguageWord;
    }

    String getForeignLanguageWord() {
        return foreignLanguageWord;
    }

    String getPartOfSpeech() {
        return partOfSpeech;
    }

    SimpleLessonSnapshot getLesson() {
        return lesson;
    }

}
