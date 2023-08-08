

public class Rule {
    String toFind;
    String toReplace;
    

    public Rule(String toFind, String toReplace) {
        this.toFind = toFind;
        this.toReplace = toReplace;
    }


    public void setToFind(String toFind) {
        this.toFind = toFind;
    }

    public void setToReplace(String toReplace) {
        this.toReplace = toReplace;
    }

    public String getToFind() {
        return toFind;
    }

    public String getToReplace() {
        return toReplace;
    }


    public Object indexOf(String expression) {
        return null;
    }

    

}
