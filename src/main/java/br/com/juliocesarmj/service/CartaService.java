package br.com.juliocesarmj.service;

import br.com.juliocesarmj.dto.CartaDTO;
import br.com.juliocesarmj.entities.CartaEntity;
import br.com.juliocesarmj.enums.ClasseEstiloPersonagens;
import br.com.juliocesarmj.enums.TipoPoderesPersonagens;
import br.com.juliocesarmj.exceptions.CartaException;
import br.com.juliocesarmj.repository.ICartaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaService implements ICartaService {

    private static final String MENSAGEM_NOT_FOUND = "Carta não encontrada";
    private static final String MENSAGEM_ERRO_INTERNO = "Erro interno identificado. Contate o suporte";
    private static final String MENSAGEM_DADOS_INCORRETOS = "Os campos tipo e classe devem possuir um valor válido";
    private static final String MENSAGEM_BARALHO_COMPLETO = "O Limite máximo de cartas foi atingido.";
    private final ICartaRepository cartaRepository;
    private final ModelMapper mapper;

    @Autowired
    public CartaService(ICartaRepository cartaRepository) {
        this.cartaRepository = cartaRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public Boolean cadastrar(CartaDTO carta) {

        try {
            if (this.cartaRepository.findAll().size() <= 30) {

                if ((carta.getTipo().equalsIgnoreCase("magia") || carta.getTipo().equalsIgnoreCase("criatura")) &&
                        (carta.getClasse().equalsIgnoreCase("mago") || carta.getClasse().equalsIgnoreCase("paladino")
                                || carta.getClasse().equalsIgnoreCase("caçador") || carta.getClasse().equalsIgnoreCase("druida")
                                || carta.getClasse().equalsIgnoreCase("qualquer"))) {
                    CartaEntity cartaEntity = this.mapper.map(carta, CartaEntity.class);
                    this.cartaRepository.save(cartaEntity);
                    return Boolean.TRUE;
                } else {
                    throw new CartaException(MENSAGEM_DADOS_INCORRETOS, HttpStatus.BAD_REQUEST);
                }
            } else {
                throw new CartaException(MENSAGEM_BARALHO_COMPLETO, HttpStatus.BAD_REQUEST);
            }
        } catch (CartaException c) {
            throw c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            //throw new CartaException(MENSAGEM_ERRO_INTERNO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Boolean alterar(CartaDTO carta) {

        try {
            this.listarPorId(carta.getId());
            CartaEntity cartaAtualizada = this.mapper.map(carta, CartaEntity.class);
            this.cartaRepository.save(cartaAtualizada);
            return Boolean.TRUE;
        } catch (CartaException c) {
            throw c;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean excluir(Integer id) {

        try {
            this.listarPorId(id);
            this.cartaRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (CartaException c) {
            throw c;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<CartaDTO> listarTodas() {

        try {
            if (!this.cartaRepository.findAll().isEmpty()) {
                return this.mapper.map(this.cartaRepository.findAll(), new TypeToken<List<CartaDTO>>() {
                }.getType());
            } else {
                throw new CartaException(MENSAGEM_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
        } catch (CartaException c) {
            throw c;
        } catch (Exception e) {
            throw new CartaException(MENSAGEM_ERRO_INTERNO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CartaDTO listarPorId(Integer id) {

        try {
            Optional<CartaEntity> cartaOptional = this.cartaRepository.findById(id);
            if (cartaOptional.isPresent()) {
                return this.mapper.map(cartaOptional.get(), CartaDTO.class);
            } else {
                throw new CartaException(MENSAGEM_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
        } catch (CartaException c) {
            throw c;
        } catch (Exception e) {
            throw new CartaException(MENSAGEM_ERRO_INTERNO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<CartaDTO> listarPorNome(String nome) {

        try {
            if (!this.cartaRepository.findByNome(nome).isEmpty()) {
                return this.mapper.map(this.cartaRepository.findByNome(nome), new TypeToken<List<CartaDTO>>() {
                }.getType());
            } else {
                throw new CartaException(MENSAGEM_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
        } catch (CartaException c) {
            throw c;
        } catch (Exception e) {
            throw new CartaException(MENSAGEM_ERRO_INTERNO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<CartaDTO> listarPorClasse(ClasseEstiloPersonagens classe) {

        try {
            if (!this.cartaRepository.findByClasse(classe).isEmpty()) {
                return this.mapper.map(this.cartaRepository.findByClasse(classe), new TypeToken<List<CartaDTO>>() {
                }.getType());
            } else {
                throw new CartaException(MENSAGEM_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
        } catch (CartaException c) {
            throw c;
        } catch (Exception e) {
            throw new CartaException(MENSAGEM_ERRO_INTERNO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<CartaDTO> listarPorTipo(TipoPoderesPersonagens tipo) {

        try {
            if (!this.cartaRepository.findByTipo(tipo).isEmpty()) {
                return this.mapper.map(this.cartaRepository.findByTipo(tipo), new TypeToken<List<CartaDTO>>() {
                }.getType());
            } else {
                throw new CartaException(MENSAGEM_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
        } catch (CartaException c) {
            throw c;
        } catch (Exception e) {
            throw new CartaException(MENSAGEM_ERRO_INTERNO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
