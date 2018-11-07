package restResources;

import PassagemAerea.PassagemAerea;
import hospedagem.Hospedagem;
import pacotes.Pacote;

/**
 *
 * @author Brendon & Lucas
 */
public class Server {

    private final PassagemAerea passagens;
    private final Hospedagem hospedagens;
    private final Pacote pacotes;

    public Server() {
        this.passagens = new PassagemAerea();
        this.hospedagens = new Hospedagem();
        this.pacotes = new Pacote(this.passagens, this.hospedagens);
    }

    public PassagemAerea getPassagens(){
        return passagens;
    }

    public Hospedagem getHospedagens(){
        return hospedagens;
    }

    public Pacote getPacotes(){
        return pacotes;
    }
}
