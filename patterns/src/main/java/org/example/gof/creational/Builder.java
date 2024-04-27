package org.example.gof.creational;

import lombok.Data;

public class Builder {
    public static void main(String[] args) {
        LombokBuilder lombokBuilder = LombokBuilder.builder()
                .setName("lombok builder")
                .build();
        System.out.println(lombokBuilder.getClass());
        System.out.println(lombokBuilder.getName());

        ClassicBuilder classicBuilder = ClassicBuilder.build()
                .setName("classic builder")
                .build();
        System.out.println(classicBuilder.getClass());
        System.out.println(classicBuilder.getName());
    }
}

@Data
@lombok.Builder(setterPrefix = "set")
class LombokBuilder {
    private String name;
}

class ClassicBuilder {
    private String name;

    public ClassicBuilder(Builder builder) {
        this.name = builder.name;
    }

    public static Builder build() {
        return new Builder();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public ClassicBuilder build() {
            return new ClassicBuilder(this);
        }
    }
}
