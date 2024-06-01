package dieu_khien;

import doi_tuong.*;

public class UserDao {
    private static final String ten = "admin";
    private static final String matKhau = "admin";

    public boolean checkUser(User user) {
        return user != null && ten.equals(user.getUserName()) && matKhau.equals(user.getPassword());
    }
}
