package dieu_khien;

import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;

import doi_tuong.*;
import giao_dien.*;

public class StudentController {
    private StudentDao studentDao;
    private StudentView studentView;

    public StudentController(StudentView view) {
        this.studentView = view;
        studentDao = new StudentDao();

        view.addAddStudentListener(new AddStudentListener());
        view.addEdiStudentListener(new EditStudentListener());
        view.addDeleteStudentListener(new DeleteStudentListener());
        view.addClearListener(new ClearStudentListener());
        view.addSortStudentGPAListener(new SortStudentGPAListener());
        view.addSortStudentNameListener(new SortStudentNameListener());
        view.addListStudentSelectionListener(new ListStudentSelectionListener());
    }

    public void showStudentView() {
        List<Student> studentList = studentDao.getListStudents();
        studentView.setVisible(true);
        studentView.showListStudents(studentList);
    }

    /**
     * Lớp AddStudentListener
     * chứa cài đặt cho sự kiện click button "Add"
     * 
     * @author viettuts.vn
     */
    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student == null)
                return;

            studentDao.add(student);
            studentView.showStudent(student);
            studentView.showListStudents(studentDao.getListStudents());
            studentView.showMessage("Thêm thành công!");
        }
    }

    /**
     * Lớp EditStudentListener
     * chứa cài đặt cho sự kiện click button "Edit"
     * 
     * @author viettuts.vn
     */
    class EditStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student == null)
                return;
            studentDao.edit(student);
            studentView.showStudent(student);
            studentView.showListStudents(studentDao.getListStudents());
            studentView.showMessage("Cập nhật thành công!");

        }
    }

    /**
     * Lớp DeleteStudentListener
     * chứa cài đặt cho sự kiện click button "Delete"
     * 
     * @author viettuts.vn
     */
    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student == null)
                return;

            studentDao.delete(student);
            studentView.clearStudentInfo();
            studentView.showListStudents(studentDao.getListStudents());
            studentView.showMessage("Xóa thành công!");
        }
    }

    /**
     * Lớp ClearStudentListener
     * chứa cài đặt cho sự kiện click button "Clear"
     * 
     * @author viettuts.vn
     */
    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentView.clearStudentInfo();
        }
    }

    /**
     * Lớp SortStudentGPAListener
     * chứa cài đặt cho sự kiện click button "Sort By GPA"
     * 
     * @author viettuts.vn
     */
    class SortStudentGPAListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentDao.sortStudentByGPA();
            studentView.showListStudents(studentDao.getListStudents());
        }
    }

    /**
     * Lớp SortStudentGPAListener
     * chứa cài đặt cho sự kiện click button "Sort By Name"
     * 
     * @author viettuts.vn
     */
    class SortStudentNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentDao.sortStudentByName();
            studentView.showListStudents(studentDao.getListStudents());
        }
    }

    /**
     * Lớp ListStudentSelectionListener
     * chứa cài đặt cho sự kiện chọn student trong bảng student
     * 
     * @author viettuts.vn
     */
    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            studentView.fillStudentFromSelectedRow();
        }
    }
}
