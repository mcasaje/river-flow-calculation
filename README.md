# River Flow Calculation

**Problem:** Calculate the volume of water (discharge) at a specific point in a stream.
Specify any assumptions that you've made.

## Quick Start

- Navigate to the root directory where the `pom.xml` 
- Run `mvn clean package` to create the jar file.
- Run `mvn exec:java` to run the app.

## Assumptions

- River data will come from an external source such as a database or an API
- depth, width, velocity will always be positive
- depth and width are provided in meters and velocity is provided in meters per second
- assumptions can be reinforced upon consumption of data (ie. upon receiving from an API or DB)

## Notes

- This was created with the intent of providing the calculation packages of area and discharge
rather than the sanitization of data input
- I timeboxed this to a day and initial implementation was about 7 hours
- The initial scope of the problem was open-ended, bu to be able to determine the volume of water
at a given point in a river using a cross-section and certain assumptions could be made
- Unit tests were prioritized for business logic (ie. calculations) and spared for data modelling

## References

- [How Streamflow is Measured](https://www.usgs.gov/special-topic/water-science-school/science/how-streamflow-measured?qt-science_center_objects=0#qt-science_center_objects )

## TODO

- [ ] Figure the best way to provide the correct units of measurement as part of the result
- [ ] Unit tests for the CrossSection builder and other classes

