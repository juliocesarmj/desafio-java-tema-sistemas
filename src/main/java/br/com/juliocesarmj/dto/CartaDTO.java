package br.com.juliocesarmj.dto;

import br.com.juliocesarmj.enums.ClasseEstiloPersonagens;
import br.com.juliocesarmj.enums.TipoPoderesPersonagens;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class CartaDTO {

    private Integer id;

    @NotBlank(message = "Informe o nome da carta.")
    private String nome;

    @NotBlank(message = "Informe uma descrição.")
    private String descricao;

    @Min(value = 0, message = "O valor mínimo para este campo é: 0")
    @Max(value = 10, message = "O valor máximo para este campo é: 10")
    private Integer ataque;

    @Min(value = 0, message = "O valor mínimo para este campo é: 0")
    @Max(value = 10, message = "O valor máximo para este campo é: 10")
    private Integer defesa;

    @NotBlank(message = "Informe o tipo de poder: MAGIA/CRIATURA")
    private String tipo;

    @NotBlank(message = "Informe a classe do personagem: MAGO, PALADINO, CAÇADOR, DRUIDA, QUALQUER")
    private String classe;
}
