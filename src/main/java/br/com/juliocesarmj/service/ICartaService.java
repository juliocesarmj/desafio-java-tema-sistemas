package br.com.juliocesarmj.service;

import br.com.juliocesarmj.dto.CartaDTO;
import br.com.juliocesarmj.enums.ClasseEstiloPersonagens;
import br.com.juliocesarmj.enums.TipoPoderesPersonagens;

import java.util.List;

public interface ICartaService {

    public Boolean cadastrar(CartaDTO carta);

    public Boolean alterar(CartaDTO carta);

    public Boolean excluir(Integer id);

    public List<CartaDTO> listarTodas();

    public CartaDTO listarPorId(Integer id);

    public List<CartaDTO> listarPorNome(String nome);

    public List<CartaDTO> listarPorClasse(ClasseEstiloPersonagens classe);

    public List<CartaDTO> listarPorTipo(TipoPoderesPersonagens tipo);

}
