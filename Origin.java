public class Origin implements Comparable<String>{

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

    public float getScore()
    {
        return score;
    }
    public void setTerm(String term)
    {
        this.term = term;
    }
    public void setSentence(String sentence)
    {
        this.sentence = sentence;
    }

    public int compareTo(String other)
    {
        return this.compareTo(other);
    }
}
