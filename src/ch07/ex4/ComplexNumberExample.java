package ch07.ex4;

public class ComplexNumberExample {
    record Complex(double real, double imaginary) {
        public static final Complex ZERO = new Complex(0,0);
        public static final Complex ONE = new Complex(1,0);
        public static final Complex I   = new Complex(0,1);

        public Complex(double real) {
            this(real, 0);
        }

        public Complex add(Complex o) {
            return new Complex(real + o.real, imaginary + o.imaginary);
        }
        public Complex subtract(Complex o) {
            return new Complex(real - o.real, imaginary - o.imaginary);
        }
        public Complex multiply(Complex o) {
            return new Complex(real*o.real - imaginary*o.imaginary,
                    real*o.imaginary + imaginary*o.real);
        }
        public double magnitude() {
            return Math.hypot(real, imaginary);
        }
        public Complex conjugate() {
            return new Complex(real, -imaginary);
        }
        @Override
        public String toString() {
            if (imaginary == 0) return String.format("%.2f", real);
            if (real == 0) return String.format("%.2fi", imaginary);
            return imaginary < 0
                    ? String.format("%.2f - %.2fi", real, -imaginary)
                    : String.format("%.2f + %.2fi", real, imaginary);
        }
    }

    public static void main(String[] args) {
        Complex z1 = new Complex(3, 4);
        Complex z2 = new Complex(1, -2);

        System.out.println("z1 = " + z1);
        System.out.println("z2 = " + z2);

        Complex sum = z1.add(z2);
        Complex diff = z1.subtract(z2);
        Complex prod = z1.multiply(z2);

        System.out.println("\nz1 + z2 = " + sum);
        System.out.println("z1 - z2 = " + diff);
        System.out.println("z1 * z2 = " + prod);

        System.out.println("\n|z1| = " + z1.magnitude());
        System.out.println("z1의 켤레 = " + z1.conjugate());

        Complex result = z1.add(z2).multiply(Complex.I);
        System.out.println("\n(z1 + z2) * i = " + result);

        Complex chain = new Complex(1,1).multiply(new Complex(2)).subtract(Complex.ONE);
        System.out.println("(1 + i) * 2 - 1 = " + chain);
    }
}
