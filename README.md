# Information Management System

This project allows users to create, read, update and delete data from a MySQL DB instance

## Getting Started
To run this project, either download the zip file or git clone this repository and open up in an IDE that is compatible with the JDK.

### Prerequisites

You will need to have Java installed. Download here: https://www.java.com/en/download/

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

The unit tests are testing the capablities of Customer, Item and Order controllers to Create, Read, Update and Delete information.

```
	@Override
	public List<Customer> readAll() {
		List<Customer> customers = customerDAO.readAll();
		for (Customer customer : customers) {
			LOGGER.info(customer);
		}
		return customers;
	}
```
## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
