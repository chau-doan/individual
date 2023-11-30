rebuild:
	mvn package

test:
	mvn test

run-and-build:
	mvn package
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar ${input} ${output}

run:
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar ${input} ${output}
ifeq ($(OS),Windows_NT)
	type ${output}
else
	cat ${output}
endif

csv:
	mvn package
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar input.csv output.csv
ifeq ($(OS),Windows_NT)
	type output.csv
else
	cat output.csv
endif

xml:
	mvn package
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar input.xml output.xml
ifeq ($(OS),Windows_NT)
	type output.xml
else
	cat output.xml
endif

json:
	mvn package
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar input.json output.json
ifeq ($(OS),Windows_NT)
	type output.json
else
	cat output.json
endif

.PHONY: run-and-build run test rebuild