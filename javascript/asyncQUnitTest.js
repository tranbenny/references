// sample async qunit test
// needs to stop testing to wait for async code to finish running before finishing tests


module('Asynchronous Tests');


test('broken async timing test', function() {
	stop(); // pauses running tests until told to
	// stop(2): parameter tells how many start functions to wait for before resuming tests
	setTimeout(function() {
		ok(true);
		start(); // tells qunit to resume running tests
	}, 100);
});

// preferred way for async testing without calls to stop/start
asyncTest('async timing test', function() {
	setTimeout(function() {
		ok(true);
		start();
	}, 1000);
});


// 3 parameters: name, number of assertions expected, functioning containing tests
test('expect test', 3, function() {
// assertion statements here
});