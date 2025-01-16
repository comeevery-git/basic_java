.PHONY: install run clean

install:
	java -version
	./gradlew --version
	./gradlew clean build --refresh-dependencies

run:
	./gradlew bootRun &

clean:
	./gradlew clean