package lesson.designpatterns.builder;

import lesson.types.StringBuilderExample;

public class Example {
    public static void main(String[] args) {
        SomeObject object = new SomeObject.Builder().age(24).name("sdf").build();
    }
}

class SomeObject {

    private final String name;
    private final int age;
    private final String department;
    private final float ball;


    public static class Builder {
        private String name;
        private int age;
        private String department;
        private float ball;

        public Builder name(String name) {
            this.name = name; return this;
        }

        public Builder age(int age) {
            this.age = age; return this;
        }

        public Builder department(String department) {
            this.department = department; return this;
        }

        public Builder ball(float ball) {
            this.ball = ball; return this;
        }

        public SomeObject build() {
            // new IllegalStateException()
            return new SomeObject(this);
        }
    }

    private SomeObject(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.department = builder.department;
        this.ball = builder.ball;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public float getBall() {
        return ball;
    }
}
