class Main {
    
    public static void main(String[] args)
    {
        Quadratic eqn1 = new Quadratic(2,2,-24);
        System.out.println(eqn1);
        Quadratic eqn2 = new Quadratic(3,12,12);
        Quadratic eqn3 = new Quadratic(1,-10,34);
        eqn1.solve();
        eqn2.solve();
        eqn3.solve();
        System.out.println(eqn1);
        System.out.println(eqn2);
        System.out.println(eqn3);
        System.out.println("Number of equation solves with real roots = " + Quadratic.realRoots);
        System.out.println("Number of equation solves with imaginary roots = " + Quadratic.imaginaryRoots);
    }
    
}