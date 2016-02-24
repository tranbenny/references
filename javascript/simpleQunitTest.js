// remember to download QUnit source code 
// load this test javascript file into the qunit text.html file to view


/*
organizing test folders: 
- Tests:
	- Libs
		-Module 1 (group tests logically)
			- SourceTests1

*/


module('module 1');

// sample test
test('my first test', function() {
	ok(true); // ok(state, message) : tests true
	// other assertion tests
	// equal(actual, expected, message)
	// notEqual(actual, expected, message)
	// deepEqual: tests complex objects, arrays
	// strictEqual: === sign
	// raises: tests if exceptions are thrown 
});

module('module 2', {
	// function runs before each test
	setup: function() {

	}, 
	// function runs after each test
	teardown: function() {

	}
});

test('my second test', function() {
	ok(true);
});

