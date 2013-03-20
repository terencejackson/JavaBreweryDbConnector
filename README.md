#JavaBreweryDbConnector

## How to use

Put this repository in your pom.xml:
<repositories>
	<repository>
		<id>JavaBreweryDbConnector</id>
		<url>https://raw.github.com/terencejackson/JavaBreweryDbConnector/mvn-repo/</url>
		<snapshots>
			<enabled>true</enabled>
			<updatePolicy>always</updatePolicy>
		</snapshots>
	</repository>
</repositories>
	
You can now get the jar with:
<dependency>
	<groupId>com.tj.brewerydb</groupId>
	<artifactId>connector</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>