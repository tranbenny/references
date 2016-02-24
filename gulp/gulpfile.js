// 4 API's in gulp
/*
gulp.task

*/

var gulp = require('gulp');


// gulp.task(name, [dependencies], function)
gulp.task('js', function() {
	return gulp.src('./src/**/*.js') // read in all javascript files 
				.pipe(concat('all.js')) // combine all files into 1
				.pipe(uglify()) // take out all white space and comments
				.pipe(gulp.dest('./build/')); // send files to destination
});

// with dependencies
// jscs, jshint = code analysis dependencies that are also run
gulp.task('js', {'jscs', 'jshint'}, function() {
// dependencies will run in parallel
// then js task starts when dependencies are done
});

// reads file into stream
// gulp.src(global file path, [options])
// options.base: defines how much of path to retain

// gulp.dest(folder, [options])
// where files are written out 

// gulp.watch(global file path, [options], tasks)
// watch task that watches for changes in javascript files and will run tasks when changes are detected
gulp.task('lint-watcher', function() {
	gulp.watch('./src/**/*.js', [
		'jshint',
		'jscs'
	]);
});