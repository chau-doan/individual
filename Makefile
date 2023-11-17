rebuild:
	mvn package

test:
	mvn test

run:
	mvn package
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar ${input} ${output}

csv:
	mvn package
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar input.csv output.csv
	cat output.csv

xml:
	mvn package
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar input.xml output.xml
	cat output.xml

json:
	mvn package
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar input.json output.json
	cat output.json

