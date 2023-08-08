public class WordsProbability {
    private String firstWord;
    private String nextWord;
    private int probability;

    public WordsProbability(String firstWord, String nextWord, int probability) {
        this.firstWord = firstWord;
        this.nextWord = nextWord;
        this.probability = probability;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String getNextWord() {
        return nextWord;
    }

    public void setNextWord(String nextWord) {
        this.nextWord = nextWord;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

}
