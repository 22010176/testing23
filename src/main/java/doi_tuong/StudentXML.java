package doi_tuong;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentXML {

    private List<Student> student;

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
