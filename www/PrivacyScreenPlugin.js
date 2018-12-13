//var exec = require('cordova/exec');

/** 
 * Not sure this will even have a JS API
 */
//exports.activate = function(arg, success, error) {
  //exec(success, error, "PrivacyScreenPlugin", "activate", [arg]);
//};
function PrivacyScreenPlugin() {
}

PrivacyScreenPlugin.prototype.show = function (successCallback, errorCallback) {
  cordova.exec(
    successCallback,
    errorCallback,
    "PrivacyScreenPlugin",
    "enable",
    [{}]
  );
};

PrivacyScreenPlugin.prototype.isAvailable = function (successCallback, errorCallback) {
  cordova.exec(
    successCallback,
    errorCallback,
    "PrivacyScreenPlugin",
    "disable",
    [{}]
  );
};

module.exports = new PrivacyScreenPlugin();
