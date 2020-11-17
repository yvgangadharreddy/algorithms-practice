package strings;

import cyclops.control.Trampoline;

import static cyclops.control.Trampoline.done;
import static cyclops.control.Trampoline.more;

public class TrampoliCyclops {
    public static void fib() {
        for(int i=0;i<1_0;i++)
            System.out.println(fibonacci(i, 0l, 1l).get());
    }

    public static Trampoline<Long> fibonacci(Integer count, Long a, Long b) {
        return  count==0 ?  done(a) : more(()->fibonacci (count - 1, b, a + b));
    }

    public static void main( String [ ] args )
    {
      fib();
    }
}
