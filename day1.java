import java.util.*;
import java.util.function.*;

public class day1 {
    public static void main(String[] args) {
        List<Integer> attendance = Arrays.asList(95, 45, 80, 30, 100);

        Predicate<Integer> p = a -> a >= 75;
        Consumer<Integer> c = a -> System.out.println(a + "%");

        System.out.println("Eligible Attendance (75% or above):");

        attendance.forEach(a -> {
            if (p.test(a)) {
                c.accept(a);
            }
        });
    }
}