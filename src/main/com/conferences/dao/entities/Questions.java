package conferences.dao.entities;

public class Questions {


    private long id;
    private String question;
    private String answer;
    private long rating;
    private long id_rp;
    private long id_usr;

    public Questions() {
    }

    public Questions(long id, String question, String answer, long rating,
                     long id_rp, long id_usr) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.rating = rating;
        this.id_rp = id_rp;
        this.id_usr = id_usr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getId_rp() {
        return id_rp;
    }

    public void setId_rp(long id_rp) {
        this.id_rp = id_rp;
    }

    public long getId_usr() {
        return id_usr;
    }

    public void setId_usr(long id_usr) {
        this.id_usr = id_usr;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", rating=" + rating +
                ", id_rp=" + id_rp +
                ", id_usr=" + id_usr +
                '}';
    }
}