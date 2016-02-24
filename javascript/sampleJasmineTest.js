// code from Udacity JavaScript Testing Course
// jasmine testing framework 

// test suite is covered through described
// each test case is surrounded by it

// format: expect().toBe() = matcher functions 

// sample test cases for an Address Book application
// Address Book = name of test suite
describe('Address Book', function() {

	var addressBook;
	var thisContact;

	// this function will run before every test
	beforeEach(function() {
		addressBook = new AddressBook();
		thisContact = new Contact(); 
	});



	it('should be able to add a contact', function() {
		// var addressBook = new AddressBook();
		// var thisContact = new Contact();
		addressBook.addContact(thisContact);
		expect(addressBook.getContact(0)).toBe(thisContract);
	});

});


// Async address book test suite 
describe('Async Address Book', function() {
	var addressBook = new AddressBook();

	// done function signals that an async call has finished
	beforeEach(function(done) {
		addressBook.getInitialContacts(function() {
			done();
		});
	});

	it('should grab initial contacts', function(done) {
		expect(addressBook.initialComplete).toBe(true);
		done();
	});




});