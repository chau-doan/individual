rebuild:
	mvn package

test:
	mvn test

run:
	mvn packagemskr
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar ${input} ${output}

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

