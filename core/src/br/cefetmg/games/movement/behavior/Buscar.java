package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;

/**
 * Guia o agente na direção do alvo.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Buscar extends AlgoritmoMovimentacao {

    private static final char NOME = 's';

    public Buscar(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Buscar(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();

        // calcula que direção tomar (configura um objeto Direcionamento 
        // e o retorna)
        // ...
        // super.alvo já contém a posição do alvo
        // agente (parâmetro) é a pose do agente que estamos guiando
        // ...
        // System.out.println(this.alvo);
        output.velocidade.x = (this.alvo.getObjetivo().x- agente.posicao.x);
        output.velocidade.y = (this.alvo.getObjetivo().y- agente.posicao.y );
        output.velocidade = output.velocidade.nor();
        output.velocidade.x *= maxVelocidade;
        output.velocidade.y *= maxVelocidade;
        
        agente.olharNaDirecaoDaVelocidade(output.velocidade);
        
//        System.out.println(agente.posicao);
        
        
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.S;
    }
}
