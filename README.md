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
    
## Versions
### 0.0.1-SNAPSHOT (2013-03-20)
* Beer functions
    * Get all beers
    * Get beers for a page
    * Get beers with a filter
    * Get a beer by its id
* Brewery functions
    * Get all breweries
    * Get breweries for a page
    * Get breweries with afilter
    * Get brewery by id

