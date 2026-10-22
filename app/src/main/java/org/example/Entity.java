package org.example;

import java.util.Objects;
import org.example.EntityState;

public class Entity {

    public int age;
    public String name;
    public float weight;
    public EntityState state;

    public Entity(int age, String name, float weight, EntityState state) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        // 1. Сравнение ссылок: если это тот же самый объект в памяти
        if (this == o) return true;

        // 2. Проверка на null и соответствие классов
        if (o == null || getClass() != o.getClass()) return false;

        // 3. Приведение типов
        Entity entity = (Entity) o;

        // 4. Сравнение полей
        // Для float используем Float.compare, чтобы корректно обрабатывать NaN и -0.0f
        return (
            age == entity.age &&
            Float.compare(entity.weight, weight) == 0 &&
            Objects.equals(name, entity.name) &&
            state == entity.state
        ); // EntityState (вероятно, enum), поэтому можно через ==
    }

    @Override
    public int hashCode() {
        // Используем Objects.hash для удобного объединения полей.
        // Для float преобразуем значение через Float.floatToIntBits, так как Objects.hash не принимает напрямую float.
        return Objects.hash(age, name, Float.floatToIntBits(weight), state);
    }
}
