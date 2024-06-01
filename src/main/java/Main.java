import java.awt.EventQueue;

import dieu_khien.LoginController;
import giao_dien.LoginView;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView view = new LoginView();
                LoginController controller = new LoginController(view);

                // hiển thị màn hình login
                controller.showLoginView();
            }
        });
    }
}