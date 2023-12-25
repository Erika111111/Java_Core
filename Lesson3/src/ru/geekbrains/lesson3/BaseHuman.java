package ru.geekbrains.lesson3;

public class Human {
    private String name;
    private int age;

    private Human(String name, int age) {
        if (name == null || name.length() < 3) {
            throw new RuntimeException("Ошибка, проверте правильность написания имени");
        } else {
            this.name = name;
        }
        if (age < 18) {
            throw new RuntimeException("Ошибка, возраст не может быть меньше 18");
        } else {
            this.age = age;
        }
    }

    // метод типа фабричный метод т.е. если нет ошибок то метод создаст экземпляр класса
    public static Human create(String name, int age) {
        if (name == null || name.length() < 3) {
            throw new RuntimeException("Ошибка, проверте правильность написания имени");

        }
        if (age < 18) {
            throw new RuntimeException("Ошибка, возраст не может быть меньше 18");
        }
        return new Human(name, age);
    }

    private Human(int age){
        this.age = age;
    }

    private Human(){
        name = "<name>";
        age = 18;

    }

    void printDisplay(){
        System.out.printf("%s - %d", name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new RuntimeException("Ошибка, возраст не может быть меньше 18");
        }
        this.age = age;
    }
}
