source ./scripts/set-secrets.sh

mvn clean verify site -P local-api-spec --file pom.xml

mvn site --file pom.xml