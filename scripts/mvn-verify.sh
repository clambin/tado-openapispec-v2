source ./scripts/set-secrets.sh

mvn verify -P local-api-spec --file pom.xml