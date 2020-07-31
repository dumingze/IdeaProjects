public class Work2 {
}
class Human{
    String name;
    int age;
    int salary;
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
}
abstract class Athlete extends Human{
    abstract void train();
    abstract void match();
}

abstract class Coach extends Human{
    int bonus;
    abstract void teach();
}
interface SpecialSkill{
    abstract void learnEnglish();
}
class TableTennisAthlete extends Athlete implements SpecialSkill{
    @Override
    void train() {

        System.out.println("乒乓球运动员训练");
    }

    @Override
    void match() {
        System.out.println("乒乓球运动员比赛");
    }

    @Override
    public void learnEnglish() {
        System.out.println("乒乓球运动员学习英语");

    }
}

class BasketballAthlete extends Athlete{
    @Override
    void train() {

    }

    @Override
    void match() {
        System.out.println("篮球运动员比赛");

    }
}
class TableTennisCoach extends Coach implements SpecialSkill{
    @Override
    void teach() {

        System.out.println("乒乓球教练教乒乓器");
    }

    @Override
    public void learnEnglish() {

        System.out.println("乒乓球教练学习英语");
    }
}
class BasketballCoach extends Coach{
    @Override
    void teach() {

        System.out.println("篮球教练教篮球");
    }
}