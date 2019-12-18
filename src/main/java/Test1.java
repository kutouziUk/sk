
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(19, "女", "s1", new Date(1000000)));
        list.add(new Student(24, "男", "s2", new Date(2000000)));
        list.add(new Student(25, "男", "s3", new Date(3000000)));
        list.add(new Student(26, "女", "s4", new Date(4000000)));
        list.add(new Student(40, "男", "s5", new Date(5000000)));
        list.add(new Student(29, "女", "s6", new Date(6000000)));
        list.add(new Student(34, "男", "s7", new Date(7000000)));
        list.add(new Student(22, "女", "s8", new Date(8000000)));
        list.add(new Student(24, "女", "s9", new Date(9000000)));
        list.add(new Student(20, "女", "s0", new Date(100000)));
//      s1 =Student{name='s2', date=Thu Jan 01 08:33:20 CST 1970}===s2 =Student{name='s1', date=Thu Jan 01 08:16:40 CST 1970}
//      s1 =Student{name='s3', date=Thu Jan 01 08:50:00 CST 1970}===s2 =Student{name='s2', date=Thu Jan 01 08:33:20 CST 1970}
        Stream<Student> stream = list.stream();
        List<Student> newList = stream.sorted((s1, s2) -> {
            System.out.println("s1 =" + s1+"====== s2 ="+ s2);
//            return s1.getDate().before(s2.getDate())? -1:1;
            return s1.getDate().compareTo(s2.getDate());
        }).collect(Collectors.toList());
        printf(newList);


        List<Student> collect = newList.stream().limit(5).collect(Collectors.toList());
        printf(collect);
        collect.stream().map(s1->{
            s1.setAge(s1.getAge()+100);
            return s1.getAge()+100;
        }).collect(Collectors.toList()).stream().forEach(System.out::println);


    }

    public static void printf(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void ss(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(19, "女", "s1", new Date(1000000)));
        list.add(new Student(24, "男", "s2", new Date(2000000)));
        list.add(new Student(25, "男", "s3", new Date(3000000)));
        list.add(new Student(26, "女", "s4", new Date(4000000)));
        list.add(new Student(40, "男", "s5", new Date(5000000)));
        list.add(new Student(29, "女", "s6", new Date(6000000)));
        list.add(new Student(34, "男", "s7", new Date(7000000)));
        list.add(new Student(22, "女", "s8", new Date(8000000)));
        list.add(new Student(24, "女", "s9", new Date(9000000)));
        list.add(new Student(20, "女", "s0", new Date(100000)));

        list.stream().filter(s->s.getAge()>24).forEach(System.out::println);
        list.stream().map(student -> {student.setAge(student.getAge()+100); return student;}).forEach(System.out::println);
        System.out.println("================================================");
        IntSummaryStatistics in = list.stream().mapToInt(Student::getAge).summaryStatistics();
        list.stream().filter(s-> s.getSex().equals("女")).forEach(System.out::println);
        System.out.println("================================================");
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.counting()));
        Set<Map.Entry<String, Long>> s = map.entrySet();
        for (Map.Entry<String, Long> strings : s) {
            System.out.println(strings.getValue()+"="+strings.getKey());
        }


    }

}


