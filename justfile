# По умолчанию выполняем запуск
default: run

# Сборка и прогон тестов
build:
    ./gradlew build

# Запуск приложения
run:
    ./gradlew run

# Быстрый запуск без повторной очистки (для повседневной разработки)
start:
    ./gradlew run --quiet

# Полная очистка и пересборка "с нуля"
rebuild:
    ./gradlew clean build

# Удаление скомпилированных файлов
clean:
    ./gradlew clean
