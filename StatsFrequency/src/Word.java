public class Word {
    private String word;
    private int counter;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Word(String word, int counter) {
        this.word = word;
        this.counter = counter;
    }

}
