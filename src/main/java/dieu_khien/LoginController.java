package dieu_khien;

import java.awt.event.*;

import doi_tuong.*;
import giao_dien.*;

public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
    private StudentView studentView;

    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserDao();
        view.addLoginListener(new LoginListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    /**
     * Lớp LoginListener
     * chứa cài đặt cho sự kiện click button "Login"
     * 
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();

            if (!userDao.checkUser(user)) {
                loginView.showMessage("username hoặc password không đúng.");
                return;
            }

            // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
            studentView = new StudentView();
            StudentController studentController = new StudentController(studentView);
            studentController.showStudentView();
            loginView.setVisible(false);
        }
    }
}
