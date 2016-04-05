var gulp= require('gulp');

// 引入插件
var uglify = require('gulp-uglify'); // 压缩
// var minifyCss = require('gulp-minify-css');
// var stripDebug = require('gulp-strip-debug'); // 该插件用来去掉console和debugger语句
// var useref = require('gulp-useref');
// var imagemin = require('gulp-imagemin');
// var pngquant = require('imagemin-pngquant');

// 任务处理的文件路径配置
var paths = {
    js: [ // js目录
        'app/*'
    ],
    css: [
        'css/*'
    ],
    img: [
        'images/*'
    ],
    html: [
        'html/*'
    ],
    lib: { // 第三方依赖文件
        js: [
            'bower_components/bootstrap/dist/js/bootstrap.js',
            'bower_components/jquery/dist/jquery.js'
        ],
        css: [
            'bower_components/bootstrap/dist/css/bootstrap.css'
        ],
        img: [
            'bower_components/bootstrap/dist/images/*'
        ]
    }
};
var output = "resources/"; // output

gulp.task('develop', function() {
    gulp.src(paths.js)
        .pipe(gulp.dest(output + '/js'));

    gulp.src(paths.lib.js)
        .pipe(gulp.dest(output + '/lib'));

    gulp.src(paths.css)
        .pipe(gulp.dest(output + '/css'));

    gulp.src(paths.lib.css)
        .pipe(gulp.dest(output + '/css'));

    gulp.src(paths.img)
        .pipe(gulp.dest(output + '/images'));

    gulp.src(paths.lib.img)
        .pipe(gulp.dest(output + '/images'));
});


// 使用 gulp.task('default') 定义默认任务
// 在命令行使用 gulp 启动 script 任务和 auto 任务
gulp.task('default', ['develop']);