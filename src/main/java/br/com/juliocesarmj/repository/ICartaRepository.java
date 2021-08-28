package br.com.juliocesarmj.repository;

import br.com.juliocesarmj.dto.CartaDTO;
import br.com.juliocesarmj.entities.CartaEntity;
import br.com.juliocesarmj.enums.ClasseEstiloPersonagens;
import br.com.juliocesarmj.enums.TipoPoderesPersonagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartaRepository extends JpaRepository<CartaEntity, Integer> {

    @Query("from CartaEntity c where c.nome = :param")
    public List<CartaEntity> findByNome(@Param("param") String nome);

    @Query("from CartaEntity c where c.classe = :param")
    public List<CartaEntity> findByClasse(@Param("param") ClasseEstiloPersonagens classe);

    @Query("from CartaEntity c where c.tipo = :param")
    public List<CartaEntity> findByTipo(@Param("param") TipoPoderesPersonagens tipo);
}
