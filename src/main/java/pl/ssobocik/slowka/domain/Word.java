package pl.ssobocik.slowka.domain;

/**
 * todo szymon opis klasy
 * Date: 15.01.12
 * Time: 09:37
 */
public class Word {

    private String word;
    private String definition;
    private String example;
    private String polishTranslation;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getPolishTranslation() {
        return polishTranslation;
    }

    public void setPolishTranslation(String polishTranslation) {
        this.polishTranslation = polishTranslation;
    }
}
