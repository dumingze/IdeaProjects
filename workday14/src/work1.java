public class work1 {
}
abstract class Vehicle{
     int a;
     int b;
     int c;

     abstract int time(int a,int b,int c);

}
 class Car extends Vehicle{

    @Override
    int time(int a, int b, int c) {

        return a*b/c;
    }
}

class Plane extends Vehicle{
    @Override
    int time(int a, int b, int c) {
        return a+b+c;
    }
}

class ship extends Vehicle{
    @Override
    int time(int a, int b, int c) {
        return a+b/c;
    }
}