.DEFAULT_GOAL := build-run
clean:
	./gradlew clean
build:
	./gradlew clean build
install:
	./gradlew clean install
test:
	./gradlew test
lint:
	./gradlew checkstyleMain
report:
	./gradlew jacocoTestReport
build-run: build run
.PHONY: build