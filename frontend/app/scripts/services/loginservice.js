'use strict';

/**
 * @ngdoc service
 * @name inzFrontendApp.loginService
 * @description
 * # loginService
 * Service in the inzFrontendApp.
 */
angular.module('inzFrontendApp')
  .service('LoginService', function (ngNotify, $cookieStore, $http, $rootScope) {

    this.login = function (username, password) {

      return $http({
        method: 'POST',
        url: '/login',
        params: {
          login: username,
          password: password
        }
      }).then(function () {
        $cookieStore.put("logged", true);
        $rootScope.currentUser = username;

        ngNotify.set('Udalo sie zalogowac!', 'success');
      }, function (response) {
        var status = response.status;
        if (status == 401) {
          ngNotify.set('Podales niepoprawne dane!', 'error');
        } else if (status == 406) {
          ngNotify.set('Konto nieaktywne!', 'error');
        } else {
          ngNotify.set('Nieznany blad podczas logowania!', 'error');
        }
      });
    };

    this.logout = function () {
      $http.get('/logout').then(function () {
          ngNotify.set('Wylogowano!', 'success');
          $cookieStore.put("logged", null);
        $cookieStore.put("authority", null);
        $rootScope.currentUser = null;
        $rootScope.authority = null;
        }, function () {
          ngNotify.set('Nie udalo sie wylogowac!', 'error');
        }
      );
    };

  });
