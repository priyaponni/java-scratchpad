class Person {
    final private String name;
    private int age;
    Person (String name, int age) throws InvalidAge {
        if(age < 10) {
            throw new InvalidAge("Person cant be less than 10");
        }
        this.name = name;
        this.age = age;
    }

    private void basePrivate() {
        System.out.println("basePrivate Person");
    }

    public void basePublic() {
        System.out.println("basePublic from Person");
    }

    public static void happiness() {
        System.out.println("All Persons are happy");
    }

    /**
        void setName() {
            this.name = "abc";
        }
    */

    protected String getEmployment() throws InvalidOccupation{
        return "Nothing";
    }
}

class Teacher extends Person {
    Teacher(String name, int age) throws InvalidAge {
        super(name, age);
    }

    public void basePrivate() {
        System.out.println("base private inside teacher");
        super.basePublic();
    }

    public static void happiness() {
        System.out.println("All teachers are happy");
    }

    @Override
    protected String getEmployment() throws InvalidOccupation{
        return this.getClass().getName();
    }
}

class Manager extends Person {
    Manager(String name, int age) throws InvalidAge, InvalidOccupation {
        super(name, age);
        if(age < 20) {
            throw new InvalidOccupation("Manager cant be less than 20");
        }
    }

    protected String getEmployment() throws InvalidOccupation {
        throw new InvalidOccupation("Managerrrrr!!!");
    }
}

class InvalidOccupation extends Exception {
    InvalidOccupation(String error) {
        super(error);
    }
}

class InvalidAge extends Exception {
    InvalidAge(String error) {
        super(error);
    }
}



public class Basics {
    public static void main(String args[]) {
        try {
            String s = "abc";
            String s1 = "abc";
            String b = s.substring(2);
            System.out.println(s.equals("abc"));
            System.out.println(s == "abc");

            System.out.println(b.equals("c"));
            System.out.println(b.equals("c"));

            System.out.println(s.equals(s1));
            System.out.println(b.equals("c"));

            Person person = new Person("Adam", 25);

            Person.happiness();

            Person teacher = new Teacher("Mary", 25);
            System.out.println(teacher.getEmployment());
            teacher.basePublic();
            if(teacher.getClass().getName().equals("Teacher")) {
                ((Teacher) teacher).basePrivate();
            }

            Teacher.happiness();
            Manager.happiness();


            Teacher t1 = new Teacher("T1", 32);
            t1.basePrivate();

            Person manager = new Manager("Nick", 39);
            System.out.println(manager.getEmployment());
            if(manager.getClass().getName().equals("Teacher")) {
                ((Teacher) manager).basePrivate();
            }
        } catch(InvalidOccupation | InvalidAge error) {
            System.out.println("Inside Exception" + error.toString());
        }
    }
}
