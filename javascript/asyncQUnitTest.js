module('Asynchronous Tests');

test('broken async timing test', function() {

	stop();
	setTimeout(function() {
		ok(true);
		start();
	}, 100);
});