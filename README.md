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
    	<version>0.0.3-SNAPSHOT</version>
    </dependency>
    
Example usage:
	System.out.println("start");
	
	// Create the injector, the async module creates the sync and async object
	Injector injector = Guice.createInjector(new BreweryDBAsyncModule());
	
	// Get the sync service
	final IBreweryDBService syncService = injector
			.getInstance(IBreweryDBService.class);
	// Do some sync calls
	Beer result = syncService.getBeerById("cBLTUw");
	System.out.println("Sync: " + result);
	//Get beers by name
	List<Beer> salvator = syncService.getAllBeers(BeersFilter.createNameFilter("Salvator"));
	System.out.println("Sync: " + salvator);
	
	// Get the async service
	final IBreweryDBServiceAsync asyncService = injector
			.getInstance(IBreweryDBServiceAsync.class);
	
	// Do some async calls
	asyncService.getAllBeers(new IResultCallback<List<Beer>>() {
	
		public void onSuccess(List<Beer> result) {
			System.out.println(result);
		}
	
		public void onError(Throwable throwable) {
			throwable.printStackTrace();
		}
	});

asyncService.getBeerById("cBLTUw", new IResultCallback<Beer>() {

	public void onSuccess(Beer result) {
		System.out.println("Async:" + result);
	}

	public void onError(Throwable throwable) {
		throwable.printStackTrace();
	}
});

System.out.println("Done");
    
## Versions
### 0.0.3-SNAPSHOT (2013-08-13)
* Asynchronous beer service
* Asynchronous guice module
* Synchronous guice module

### 0.0.1-SNAPSHOT (2013-03-20)
* Beer functions
    * Get all beers
    * Get beers for a page
    * Get beers with a filter
    * Get a beer by its id
* Brewery functions
    * Get all breweries
    * Get breweries for a page
    * Get breweries with a filter
    * Get brewery by id

