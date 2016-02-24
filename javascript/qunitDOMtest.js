// sample tests for the DOM with QUnit 


test('DOM test', function() {
	// tests if there is only one div with this id
	strictEqual($('#mytestdiv').length, 1);
	// tests if the div's text equals a certian value 
	strictEqual($('#mytestdiv').text, "");
});