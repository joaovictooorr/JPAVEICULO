package br.com.veiculos.DAO;

import br.com.veiculos.domain.Carro;

public interface ICarroDAO {

    public Carro cadastrar(Carro carro);
    Carro atualizar(Carro carro);
}
