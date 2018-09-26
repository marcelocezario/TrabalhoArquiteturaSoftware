APP.factory("MutuarioService", function($resource) {
  return $resource('http://localhost:8080/biblioteca/api/mutuarios/:id', {id:'@_id'},{
    update: {
      method  : 'PUT',
      url     : 'http://localhost:8080/biblioteca/api/mutuarios/:id',
      params  : { id: '@id' },
      isArray : false
    }
  });
});
