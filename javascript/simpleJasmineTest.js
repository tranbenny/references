/*
- make sure to get jasmine source code
- create your own spec runner file, include dependencies
- create a test file 


jasmine organization: 
- tests are nested in describe blocks, can use nested described blocks
functions
- it() : test functon
- beforeEach, afterEach

- add an 'x' before a function to skip a test 


*/

describe('User', function() {
	/* tests */

	// code to run before each test
	beforeEach(function() {
		// creating a custom matcher
		// this.addMatchers function takes an object with the name of matcher and function
		this.addMatchers({
			toBeFive: function() {

				// adds a custom error message for failed tests
				this.message = function() {
					return this.actual + " is not 5";
				}

				return this.actual === 5;
			}
		});

	});

	// code to run after each test
	afterEach(function() {

	});

	// 2 parameters: description, function
	it('should be able to log in', function() {
		// assertion tests here
		// example matcher functions
		expect(x).toEqual(y);
		expect(x).toBe(y); // strict equals
		expect(x).toMatch(pattern);
		expect(x).toBeDefined();

	});
});