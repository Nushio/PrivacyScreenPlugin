//var exec = require('cordova/exec');

/** 
 * Not sure this will even have a JS API
 */
//exports.activate = function(arg, success, error) {
  //exec(success, error, "PrivacyScreenPlugin", "activate", [arg]);
//};
function PrivacyScreenPlugin() {
}

PrivacyScreenPlugin.prototype.enable = function (successCallback, errorCallback) {
  cordova.exec(
    successCallback,
    errorCallback,
    "PrivacyScreenPlugin",
    "enable",
    [{}]
  );
};

PrivacyScreenPlugin.prototype.disable = function (successCallback, errorCallback) {
  cordova.exec(
    successCallback,
    errorCallback,
    "PrivacyScreenPlugin",
    "disable",
    [{}]
  );
};

module.exports = new PrivacyScreenPlugin();
