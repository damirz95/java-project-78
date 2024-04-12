.DEFAULT_GOAL := build-run
clean:
	make -C app clean
build:
	make -C app build
install:
	make -C app install
run:
	make -C app run
run-dist:
	make -C app run-dist
test:
	make -C app test
lint:
	make -C app lint
report:
	make -C app report
build-run: build run
.PHONY: build