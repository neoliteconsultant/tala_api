# Play REST API


This is the example project for Making a REST API in Play

## Appendix

### Running

You need to download and install sbt for this application to run.

Once you have sbt installed, the following at the command prompt will start up Play in development mode:

```bash
sbt run
```

Play will start up on the HTTP port at <http://localhost:9000/>.   You don't need to deploy or reload anything 
-- changing any source code while the server is running will automatically recompile and hot-reload 
the application on the next HTTP request. 

### Usage

If you call the same URL from the command line, you’ll see JSON. Using curl, we can execute the command:


GET http://localhost:9000/balance/01108128953100
PATCH http://localhost:9000/withdrawal/01108128953100/300
PATCH http://localhost:9000/deposit/01108128953100/300

### Load Testing

The best way to see what Play can do is to run a load test.  We've included Gatling in this test project for integrated load testing.

Start Play in production mode, by [staging the application](https://www.playframework.com/documentation/2.5.x/Deploying) and running the play script:s

```bash
sbt stage
cd target/universal/stage
bin/play-rest-api-example -Dplay.crypto.secret=testing
```

Then you'll start the Gatling load test up (it's already integrated into the project):

```bash
sbt gatling:test
```

For best results, start the gatling load test up on another machine so you do not have contending resources.  You can edit the [Gatling simulation](http://gatling.io/docs/2.2.2/general/simulation_structure.html#simulation-structure), and change the numbers as appropriate.

Once the test completes, you'll see an HTML file containing the load test chart:

```bash
 ./rest-api/target/gatling/gatlingspec-1472579540405/index.html
```

That will contain your load test results.
