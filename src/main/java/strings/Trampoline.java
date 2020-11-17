package strings;

import java.math.BigInteger;

class Trampoline<T>
{
    public T done() { return null; }
    public Trampoline<T> more() { return null; }

    T execute() {
        Trampoline<T>  trampoline = this;

        while (trampoline.done() == null) {
            trampoline = trampoline.more();
        }

        return trampoline.done();
    }
}

class Factorial
{
    public static Trampoline<BigInteger> factorial(final int n, final BigInteger product)
    {
        if(n <= 1) {
            return new Trampoline<BigInteger>() { public BigInteger done() { return product; } };
        }
        else {
            return new Trampoline<BigInteger>() {
                public Trampoline<BigInteger> more() {
                    return factorial(n - 1, product.multiply(BigInteger.valueOf(n)));
                }
            };
        }
    }

    public static void main( String [ ] args )
    {
        System.out.println(factorial(5, BigInteger.ONE).execute());
    }
}




