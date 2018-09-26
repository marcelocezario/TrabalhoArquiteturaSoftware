APP.controller('EmprestimoController', function($scope, $state, $stateParams, EmprestimoService , MutuarioService, LivroService) {
  $scope.emprestimos = EmprestimoService.query();
  $scope.successMessage = $stateParams.successMessage;
});

APP.controller('EmprestimoNovoController', function($scope, $state, $stateParams, EmprestimoService , MutuarioService, LivroService) {
  $scope.emprestimo = new EmprestimoService();
  $scope.livro = new LivroService();
  $scope.mutuario = new MutuarioService();

  $scope.criarEmprestimo = function() {
    $scope.emprestimo.$save(
      function() {
        $state.go('emprestimos', {'successMessage': "Emprestimo criado com sucesso!"});
      }, function() {
        $scope.errorMessage = "Ocorreu um erro no servidor. Verifique se todos os campos foram preenchidos corretamente.";
      }
    );
  };
});

APP.controller('EmprestimoEditarController', function($scope, $state, $stateParams,  EmprestimoService , MutuarioService, LivroService) {
  $scope.emprestimos = EmprestimoService.get({ id: $stateParams.id });
  $scope.livros = LivroService.query();
  $scope.mutuarios = MutuarioService.query();


  $scope.atualizarEmprestimo = function() {
    $scope.emprestimo.$update(
      function() {
        $state.go('emprestimos', {'successMessage': "emprestimo atualizado com sucesso!"});
      }, function() {
        $scope.errorMessage = "Ocorreu um erro no servidor. Verifique se todos os campos foram preenchidos corretamente.";
      }
    );
  };
});