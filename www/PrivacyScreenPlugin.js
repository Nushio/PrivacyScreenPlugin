var exec = require('cordova/exec');

// exports.activate = function(arg, success, error) {
//   exec(success, error, "PrivacyScreenPlugin", "activate", [arg]);
// };
var PrivacyScreenPlugin = {
    serviceName: "PrivacyScreenPlugin",
    enable: function(success, error) {
      exec(success, error, this.serviceName, "enable");
    },
    disable: function(success, error) {
      exec(success, error, this.serviceName, "disable");
    },
}

// PrivacyScreenPlugin.prototype.enable = function (successCallback, errorCallback) {
//   cordova.exec(
//     successCallback,
//     errorCallback,
//     "PrivacyScreenPlugin",
//     "enable",
//     [{}]
//   );
// };

// PrivacyScreenPlugin.prototype.disable = function (successCallback, errorCallback) {
//   cordova.exec(
//     successCallback,
//     errorCallback,
//     "PrivacyScreenPlugin",
//     "disable",
//     [{}]
//   );
// };

module.exports = PrivacyScreenPlugin;
