

import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    static Stream<Object[]> inputStream(){
        return Stream.of(
                //  new Object[]{ new Integer[][] {{mid, big, small}} },
                new Object[]{ new Integer[][] {{2, 3, 1}} },
                new Object[]{ new Integer[][] {{5, 8, 2}} },
                new Object[]{ new Integer[][] {{6, 9, 3}} },
                new Object[]{ new Integer[][] {{878, 923, 754}} },
                new Object[]{ new Integer[][] {{22, 58, 13}} }
        );
    }

    @ParameterizedTest
    @MethodSource("inputStream")
    void testPRQ(Integer[][] testCase){
        PriorityQueue<Integer> prq = new PriorityQueue();

        int a = testCase[0][0];
        int b = testCase[0][1];
        int c = testCase[0][2];
        prq.add(a);
        prq.add(b);
        prq.add(c);

        a = prq.poll();
        b = prq.poll();
        c = prq.poll();
        System.out.println("first: " + a);
        System.out.println("second: " + b);
        System.out.println("third: " + c);
        System.out.println("end!!!!!! ");
        assertEquals(a, testCase[0][2]);
        assertEquals(b, testCase[0][0]);
        assertEquals(c, testCase[0][1]);
    }


    @Test
    public void whenExceptionThrown_thenAssSucceeds(){
        PriorityQueue<Integer> prq = new PriorityQueue();


        Exception exception0 = assertThrows(IllegalArgumentException.class, ()->{
            PriorityQueue<Integer> prq1 = new PriorityQueue(0);
        });

        Exception exception1 = assertThrows(NullPointerException.class, () -> {
            prq.offer(null);
        });

        Exception exception2 = assertThrows(NullPointerException.class, () -> {
            prq.add(null);
        });

        Exception exception2_5 = assertThrows(ClassCastException.class, ()->{
            PriorityQueue prq1 = new PriorityQueue();
            prq1.add(3);
            prq1.add("a");
        });

        Exception exception3 = assertThrows(NullPointerException.class, () -> {
            Integer[] arr1 = null;
            Integer[] arr2 = prq.toArray(arr1);
        });

    }
}
