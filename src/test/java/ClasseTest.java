import br.com.veiculos.DAO.*;
import br.com.veiculos.domain.Acessorio;
import br.com.veiculos.domain.Carro;
import br.com.veiculos.domain.Marca;
import org.junit.Test;
import java.util.ArrayList;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ClasseTest {
    private IAcessorioDAO acessorioDAO;
    private ICarroDAO carroDAO;
    private IMarcaDAO marcaDAO;

    public ClasseTest(){
        acessorioDAO = new AcessorioDAO();
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
    }


    @Test
    public void cadastrar(){
        Carro carro = criarCarro("FIESTA","FORD","FAROL");
        assertNotNull(carro);
        assertNotNull(carro.getId());
        carro = carroDAO.cadastrar(carro);
        assertNotNull(carro);


    }

    private Marca criarMarca(String nomerMarca){
        Marca marca = new Marca();
        marca.setNomeMarca(nomerMarca);
        return marcaDAO.cadastrar(marca);
    }

    private Carro criarCarro(String nomeCarro, String nomeMarca, String nomeAcessorio){
        Marca marca = criarMarca(nomeMarca);

        Carro carro = new Carro();
        carro.setNomeCarro(nomeCarro);
        carro.setMarca(marca);

        carro = carroDAO.cadastrar(carro);

        List<Acessorio> acessorios = new ArrayList<>();
        Acessorio acessorio = criarAcessorio(nomeAcessorio, carro);
        acessorios.add(acessorio);

        carro.setAcessorio(acessorios);

        return carro;
    }

    private Acessorio criarAcessorio(String nomeAcessorio, Carro carro){
        Acessorio acessorio = new Acessorio();
        acessorio.setNomeAcessorio(nomeAcessorio);
        acessorio.setCarro(carro);
        return acessorioDAO.cadastrar(acessorio);
    }


}
