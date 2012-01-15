import domain.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * todo szymon opis klasy
 * Date: 15.01.12
 * Time: 09:36
 */
public class WordLoader {


    public static List<Word> wczytajSlowka() {
        ArrayList<Word> wordsList = new ArrayList<Word>();
        for (int i = 0; i < 5; i++) {
            Word word = new Word();
            word.setWord("to recreate" + i);
            word.setDefinition("[verb] - to make something exist or happen again");
            word.setExample("The novel recreates the atmosphere of medieval times and takes us into a world of tragedy and fear.");
            word.setPolishTranslation("odtworzyć coś");

            wordsList.add(word);
        }
        return wordsList;
    }
}
