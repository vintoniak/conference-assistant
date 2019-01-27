package conferences.dao.entities;

public class Reports {
    private long id;
    private String name;
    private String info;
    private String date;
    private long fk_id_cf;

    public Reports() {
    }

    public Reports(long id, String name, String info, String date, long fk_id_cf) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.date = date;
        this.fk_id_cf = fk_id_cf;
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

    public long getFk_id_cf() {
        return fk_id_cf;
    }

    public void setFk_id_cf(long fk_id_cf) {
        this.fk_id_cf = fk_id_cf;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", date='" + date + '\'' +
                ", fk_id_cf=" + fk_id_cf +
                '}';
    }
}
