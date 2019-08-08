package practice;

import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.Queue;

public class ManyThead {
  /*  public static void main(String[] args)
    {
        Queue<String> queue = new LinkedList<String>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        queue.add("6");
        queue.add("7");
        queue.add("8");
        queue.add("9");
        queue.add("10");
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();

       *//* Thread t1 = new Thread();
        Thread t2 = new Thread();

        t1.run();
        ManyThead manyThead = new ManyThead();*//*

    }*/

    public static void main(String[] args) {
        ManyThead manyThead = new ManyThead();
        Person person1 = new Person();
        person1.setId(1);
        person1.setSex("男");
        person1.setName("第一人");

        String name = person1.getName();

        try {
            Person person2 = Person.class.newInstance();
            person2.setName("");
            try {
                Class<?> id = person1.getClass().getDeclaredField("id").getDeclaringClass();
                /*if (id instanceof Integer){

                }*/
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

class Person {

    private Integer id;
    private String sex;
    private String name;

    public Person() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

