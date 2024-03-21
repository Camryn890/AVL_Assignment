/**
 * Author: Hussein Suleman
 * Represents the class Origin which stores the term, sentence and confidence score
 */
public class Origin implements Comparable<String>{

    /**
     * The term
     */
    public String term;

    /**
     * The sentence
     */
    public String sentence;

    /**
     * The score
     */
    public float score;

    /**
     * Constructs the origin object that stores the term, sentence and score
     * @param term The term
     * @param sentence The sentence
     * @param score The score
     */
    Origin(String term, String sentence, float score)
    {
        this.term = term;
        this.sentence = sentence;
        this.score = score;
    }

    /**
     * Gives the term
     * @return The term
     */
    public String getTerm()
    {
        return term;
    }

    /**
     * Gets the sentence
     * @return The sentence
     */
    public String getSentence()
    {
        return sentence;
    }

    /**
     * Gives the confidence level
     * @return The score
     */
    public float getScore()
    {
        return score;
    }

    /**
     * Sets the term
     * @param term The new term to be set
     */
    public void setTerm(String term)
    {
        this.term = term;
    }

    /**
     * Sets the sentence
     * @param sentence The new sentence to be set
     */
    public void setSentence(String sentence)
    {
        this.sentence = sentence;
    }

    /**
     * Compares the term stored in this object to the other string given
     * @param other The object to be compared.
     * @return An integer to determine if this term less than, more than or equal to  string given
     */
    public int compareTo(String other)
    {
        return this.compareTo(other);
    }
}
