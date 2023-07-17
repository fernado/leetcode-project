import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTest {

    @Test
    public void doTest0() {
        Stu stu = new Stu();
        stu.setName("fernando");
        List<String> ll = new ArrayList<>();
        ll.add("ABC");
        ll.add("BCD");
        stu.setList(ll);

        Stu stu1 = stu;
        Stu stu2 = stu;
        stu1.setName("loncy");
        stu1.getList().remove("BCD");

        System.out.println(stu1);
        System.out.println(stu2);

    }


    static class Stu {
        private String name;
        private List<String> list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Stu{");
            sb.append("name='").append(name).append('\'');
            sb.append(", list=").append(list);
            sb.append('}');
            return sb.toString();
        }
    }
}
