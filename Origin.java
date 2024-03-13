public class Origin implements Comparable<Origin>{

    public String term;
    public String sentence;
    public float score;

    Origin(String term, String sentence, float score)
    {
        this.term = term;
        this.sentence = sentence;
        this.score = score;
    }
    public String getTerm()
    {
        return term;
    }

    public String getSentence()
    {
        return sentence;
    }
    public void setTerm(String term)
    {
        this.term = term;
    }

    public void setSentence(String sentence)
    {
        this.sentence = sentence;
    }

    public int compareTo(Origin other)
    {
        return this.getTerm().compareTo(other.getTerm());
    }
}