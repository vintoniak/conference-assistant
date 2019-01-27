package conferences.dao.entities;

public class User {

        private long id;
        private String nickName;
        private String email;
        private String password;
        // 1 is admin, 2 is moderator, 3 is user
        private int role;

        public User() {
        }

        public User(long id, String nickName, String email, String password, int role) {
            this.id = id;
            this.nickName = nickName;
            this.email = email;
            this.password = password;
            this.role = role;
        }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }


    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
