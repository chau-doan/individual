rebuild:
	mvn package

run:
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar ${input}

build-and-run:
	mvn package
	java -jar ./target/individual-project-1.0-SNAPSHOT.jar ${input} ${output}