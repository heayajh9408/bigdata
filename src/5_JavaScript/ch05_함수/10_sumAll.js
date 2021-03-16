// JavaScript source code(10_sumAll.js)
function sumAll() {
    var result=0;
    if (arguments.length == 0) {
        result = -999;
    } else {
        //for (var idx = 0; idx < arguments.length; idx++) {
        for (var idx in arguments) {
            result += arguments[idx];
        }
    }
    return result;
}