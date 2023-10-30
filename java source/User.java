public class User {
    private static int uid = 12345;
    private String userName;
    private String userId;
    private int score = 100;
    public User(String userName){
        this.userName = userName;
        this.userId = userName+"_"+uid;
        uid+=1;
    } 
    public String getUserName() {
        return this.userName;
    }
    public String getUserId() {
        return this.userId;
    }
    public int getScore() {
        return this.score;
    }
    public void modifyScore(int score){
        this.score+=score;
    }
    public static User loginUser(String name){
        return new User(name);
    }

    @Override
    public String toString() {
        return "[" +
            " UserName='" + getUserName() + "'" +
            ", UserId='" + getUserId() + "'" +
            ", Score='" + getScore() + "'" +
            "]";
    }
}
