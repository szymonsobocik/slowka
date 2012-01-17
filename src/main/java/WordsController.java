import com.thoughtworks.xstream.XStream;
import pl.ssobocik.domain.Word;

import java.io.*;
import java.util.List;

/**
 * todo szymon opis klasy
 * Date: 15.01.12
 * Time: 09:36
 */
public class WordsController {


    private static String wordsFilePath = "slowka.xml";

    public static List<Word> loadWords() {
        File file = new File(wordsFilePath);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String xml = "";
            String tempXML;
            while ((tempXML = bufferedReader.readLine()) != null) {
                xml += tempXML;
            }
            XStream xStream = createXStream();
            List<Word> words = (List<Word>) xStream.fromXML(file);
            return words;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        /*ArrayList<Word> wordsList = new ArrayList<Word>();
        for (int i = 0; i < 5; i++) {
            Word word = new Word();
            word.setWord("to recreate" + i);
            word.setDefinition("[verb] - to make something exist or happen again");
            word.setExample("The novel recreates the atmosphere of medieval times and takes us into a world of tragedy and fear.");
            word.setPolishTranslation("odtworzyć coś");

            wordsList.add(word);
        }
        return wordsList;*/
    }

    private static XStream createXStream() {
        XStream xStream = new XStream();
        xStream.alias("word", Word.class);
        return xStream;
    }

    public static void saveWords(List<Word> words) throws IOException {
        if (words != null) {
            XStream xStream = createXStream();
            String xml = xStream.toXML(words);
            System.out.println(xml);
            File file = new File(wordsFilePath);
            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new FileWriter(file));
                out.write(xml);
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        }
    }
}
