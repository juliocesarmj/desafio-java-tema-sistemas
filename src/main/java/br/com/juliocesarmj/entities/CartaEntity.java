package br.com.juliocesarmj.entities;

import br.com.juliocesarmj.enums.ClasseEstiloPersonagens;
import br.com.juliocesarmj.enums.TipoPoderesPersonagens;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_carta")
@Data
@NoArgsConstructor
public class CartaEntity implements Serializable {

    private static final long serialVersionUID = 323719161264847482L;

    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "nome")
    private String nome;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "descricao")
    private String descricao;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "ataque")
    private Integer ataque;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "defesa")
    private Integer defesa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoPoderesPersonagens tipo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "classe")
    @Enumerated(EnumType.STRING)
    private ClasseEstiloPersonagens classe;
}
