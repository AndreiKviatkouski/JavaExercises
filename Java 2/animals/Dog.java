/**
 * Class Dog
 * 
 * @author  Sergey Iryupin
 * @version 0.1 dated Mar 18, 2017
 */
public class Dog extends Animal implements Swimable {

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
    }
}