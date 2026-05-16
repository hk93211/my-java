public class a8_Constructor {
    public static void main(String[] args) {
        // 默认会调用父类的构造器, 可以手动指定调用父类的哪个构造器
        Zi zi = new Zi();
    }
}

class Fu {
    private String name;
    private String sex;

    public Fu() {
        System.out.println("父类构造器执行");
    }

    public Fu(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}

class Zi extends Fu {
    private String skill;

    public Zi() {
        // super(); // 默认就存在的, 写不写都存在
        // super(111); // 指定调用父类的有参构造器
        System.out.println("子类构造器执行");
    }

    public Zi(String name, String sex, String skill) {
        super(name, sex);
        this.skill = skill;
    }
}