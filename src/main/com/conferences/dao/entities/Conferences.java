package conferences.dao.entities;

public class Conferences {

    private long id;
    private String name;
    private String info;
    private String date;

    public Conferences() {
    }

    public Conferences(long id, String name, String info, String date) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Conferences{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
