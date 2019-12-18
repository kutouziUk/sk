import java.util.Date;

public class Student {

    private int age;
    private String sex;
    private String name;
    private Date date;

    public Student(int age, String sex, String name, Date date) {
        this.age = age;
        this.sex = sex;
        this.name = name;
        this.date = date;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
