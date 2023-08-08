public class WordPair {
    public String firstWord;

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public String secondWord;

    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }

    public WordPair(String firstWord, String secondWord) {
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WordPair other = (WordPair) obj;
        if (firstWord == null) {
            if (other.firstWord != null)
                return false;
        } else if (!firstWord.equals(other.firstWord))
            return false;
        if (secondWord == null) {
            if (other.secondWord != null)
                return false;
        } else if (!secondWord.equals(other.secondWord))
            return false;
        return true;
    }

    // WordPair wp1 = new WordPair("a", "b")
    // WordPair wp2 = new WordPair("a", "b")

    // wp1 == wp2 => false (daca equals nu este @Override) (implicit compara adresele din memorie)
    // wp1 == wp2 => true (cu fn de mai sus) (alterat de noi pt a compara valorile din interior)

}
