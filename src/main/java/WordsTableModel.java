import pl.ssobocik.domain.Word;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * todo szymon opis klasy
 * Date: 15.01.12
 * Time: 10:10
 */
public class WordsTableModel extends AbstractTableModel{

    String[] columns = {"Word", "Definition", "Example", "Polish translation"};
    private List<Word> words;

    public int getRowCount() {
        return words != null ? words.size() : 0;
    }

    public int getColumnCount() {
        return columns.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Word word = words.get(rowIndex);
        if (columnIndex == 0){
            return word.getWord();
        } else if (columnIndex == 1){
            return word.getDefinition();
        } else if (columnIndex == 2){
            return word.getExample();
        } else if (columnIndex == 3){
            return word.getPolishTranslation();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }
}
